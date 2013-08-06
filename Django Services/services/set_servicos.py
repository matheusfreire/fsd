from services import Description
from services import loan
from services import Login
from threading import Thread

def main():
	print "Settando todos os servicos"
	ip = '127.0.0.1'

	th1 = Thread(target = Description.main, args = (ip, ))
	th2 = Thread(target = loan.main, args = (ip, ))
	th3 = Thread(target = Login.main, args = (ip, ))

	th1.start()
	th2.start()
	th3.start()

	th1.join()
	th2.join()
	th3.join()



