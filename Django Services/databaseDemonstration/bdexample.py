from domain import models

def print_all_descriptions():
	desc = models.Description.objects.all()
	print "\nTitles: \n"
	for e in desc:
		print "Description: ISBN" + str(e.isbn) + " Name: " + e.name + " Author " + e.author

def print_all_books():
	books = models.Book.objects.all()
	print "\nBooks in Stock: \n"
	for e in books:
		print "Book: Name: " + e.description.name + " id: " + str(e.collection_id)
		if e.status:
			print " Avaliable"
		else:
			print " Unavaliable"

def print_all_user():
	users = models.User.objects.all()
	print "\nUsers:\n"
	for e in users:
		print "User id: " + str(e.rb) + " Name: " + e.name + " email: " + e.email 

def print_all_loans():
	loans = models.Loan.objects.all()
	print "\nLoans:"
	for e in loans:
		print "\nLoan register: " + str(e.id)
		print "Book id: " + str(e.book.collection_id) + " Book name: " + e.book.description.name
		print "User name: " + e.user.name
