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

class User(ClassModel):
	rb = Integer
	name = String
	email = String
'''
#Classes de Falhas que podem surgir
class DescriptionNotFoundFault(exception.Fault):
	__namespace__ = 'DescriptionNotFoundFault'

class DescriptionAlreadyExistsFault(exception.Fault):
	__namespace__ = 'DescriptionAlreadyExistsFault'
'''

class UserManagerService(DefinitionBase):

	@soap(Integer, Integer, _returns=Integer)
	def make_a_loan(self, book_id, user_rb):

		books = models.Book.objects.filter(collection_id = book_id).filter(status = True)
		if len(books) <= 0:
			return -1;
		else:
			loan = models.Loan()
			loan.book = books[0]
			temp_user = models.User.objects.filter(rb = user_rb)
			if len(temp_user) < 0:
				return -2;
			loan.user = temp_user[0]

			books[0].status = False
			books[0].save()
			loan.save()
			
			return 0;

	@soap(User, _returns=Integer)
	def add_user(self, user):

		users = models.User.objects.filter(rb = user.rb)
		if len(users) > 0:
			return -1;
		else:
			u = models.User()
			u.rb = user.rb
			u.name = str(user.name).decode("utf-8")
			u.email = str(user.email).decode("utf-8")
			
			return 0;

	@soap(Integer, _returns=Integer)
	def return_a_loan(self, book_id):

		books = models.Book.objects.filter(collection_id = book_id)
		if len(books) <= 0:
			return -1;
		else:
			books[0].status = True
			books[0].save()
			
			return 0;


def main(ip):
    from wsgiref.simple_server import make_server
    soap_application = soaplib.core.Application([UserManagerService], 'usermanager')
    wsgi_application = wsgi.Application(soap_application)
    server = make_server(ip, 1235, wsgi_application)
    print "Setando servico Loan"
    server.serve_forever()
    





