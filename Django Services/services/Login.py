import soaplib
from soaplib.core.service import rpc, DefinitionBase, soap
from soaplib.core.model.primitive import String, Integer, Boolean
from soaplib.core.model import exception
from soaplib.core.server import wsgi
from soaplib.core.model.clazz import ClassModel, Array
from domain import models
from soaplib.core.wsdl import WSDL
from soaplib.core.server import wsgi


class LoginService(DefinitionBase):

	@soap(String, String, _returns=Boolean)
	def login(self, temp_login, temp_password):
		
		users = models.Login.objects.filter(login = str(temp_login).decode("utf-8"), password = str(temp_password).decode("utf-8"))
		print len(users)
		if len(users) <= 0:
			return False

		return True

def main(ip):
    from wsgiref.simple_server import make_server
    soap_application = soaplib.core.Application([LoginService], 'login')
    wsgi_application = wsgi.Application(soap_application)
    server = make_server(ip, 1236, wsgi_application)
    print "Setando servico Login"
    server.serve_forever()