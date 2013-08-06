from django.db import models
from domain import models

def main():
	
	login = models.Login()
	login.login = "admin"
	login.password = "admin"
	login.save()

	desc = models.Description()
	desc.isbn = 1
	desc.name = "UML"
	desc.author = "Larman"
	desc.save()

	desc2 = models.Description()
	desc2.isbn = 2
	desc2.name = "Design Patterns"
	desc2.author = "GoF"
	desc2.save()

	book1 = models.Book()
	book1.description = desc
	book1.collection_id = 1
	book1.status = True
	book1.save()

	book2 = models.Book()
	book2.description = desc
	book2.collection_id = 2
	book2.status = True
	book2.save()

	book3 = models.Book()
	book3.description = desc2
	book3.collection_id = 3
	book3.status = True
	book3.save()

	user = models.User()
	user.rb = 1
	user.name = 'Arthur'
	user.email = 'arthurmde'
	user.save()

	user2 = models.User()
	user2.rb = 2
	user2.name = 'Matheus'
	user2.email = 'matheus'
	user2.save()
