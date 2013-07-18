import soaplib
from soaplib.core.service import rpc, DefinitionBase, soap
from soaplib.core.model.primitive import String, Integer, Boolean
from soaplib.core.model import exception
from soaplib.core.server import wsgi
from soaplib.core.model.clazz import ClassModel, Array
from domain import models
from soaplib.core.wsdl import WSDL
from soaplib.core.server import wsgi


#Classes de Modelo para XSD
class Description(ClassModel):
	isbn = Integer
	name = String
	author = String

class Book(ClassModel):
	description = Description
	collection_id = Integer
	status = Boolean

'''
#Classes de Falhas que podem surgir
class DescriptionNotFoundFault(exception.Fault):
	__namespace__ = 'DescriptionNotFoundFault'

class DescriptionAlreadyExistsFault(exception.Fault):
	__namespace__ = 'DescriptionAlreadyExistsFault'
'''

class DescriptionDAOService(DefinitionBase):

	@soap(Description, _returns=Integer)
	def add_description(self, description):
		
		if len(models.Description.objects.filter(isbn = str(description.isbn).decode("utf-8"))) > 0:
			return -1;
		else:
			temp_description = models.Description()
			temp_description.isbn = int(description.isbn)
			temp_description.name = str(description.name).decode("utf-8")
			temp_description.author = str(description.author).decode("utf-8")
			temp_description.save()
			
			return 0;

	@soap(String, _returns=Description)
	def get_description_by_isbn(self, isbn):
		temp_description = models.Description.objects.filter(isbn = isbn)
		if len(temp_description) > 0:
			description = Description()
			description.isbn = temp_description[0].isbn
			description.name = temp_description[0].name
			description.author = temp_description[0].author
			return description
		else:
			return None

	@soap(String, _returns=Description)
	def get_description_by_name(self, name):
		temp_description = models.Description.objects.filter(name = name)
		if len(temp_description) > 0:
			description = Description()
			description.isbn = temp_description[0].isbn
			description.name = temp_description[0].name
			description.author = temp_description[0].author
			return description
		else:
			return None

	#Relacionado a Livros
	@soap(Book, _returns=Integer)
	def add_book(self, book):
		
		temp_description = models.Description.objects.filter(isbn = book.description.isbn)
		if len(temp_description) < 0:
			return -1

		temp_book = models.Book()
		temp_book.description = temp_description[0]
		temp_book.collection_id = book.collection_id
		temp_book.status = book.status

		temp_book.save()

def main():
    from wsgiref.simple_server import make_server
    soap_application = soaplib.core.Application([DescriptionDAOService], 'description')
    wsgi_application = wsgi.Application(soap_application)
    server = make_server('192.168.254.5', 1234, wsgi_application)
    server.serve_forever()
    

'''
class BookDAOService(DefinitionBase):

	@soap(Book, _returns=Integer)
	def add_book(self, book):
		
		temp_description = models.Description.objects.filter(isbn = book.isbn)
		temp_description.isbn = book.description.isbn
		temp_description.title = book.description.title
		temp_description.author = book.description.author
		temp_description.year = book.description.year

		temp_book = models.Book.objects()
		temp_book.description = temp_description
		temp_book.collection_id = book.collection_id
		temp_book.status = book.status

		temp_book.save()
'''



