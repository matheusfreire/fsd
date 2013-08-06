package controller;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import loan.services.User;
import usermanager.Application_PortType;
import usermanager.Application_Service;
import usermanager.Application_ServiceLocator;

public class TestUserManager {

	public static void main(String[] args) throws ServiceException, RemoteException {
		BigInteger isbn = new BigInteger("2");
		BigInteger book = new BigInteger("1");
		BigInteger user = new BigInteger("1");
		BigInteger u1 = new BigInteger("3");
		Application_Service service = new Application_ServiceLocator();
		Application_PortType app = service.getApplication();
		
		
		
		System.out.println("Instanciando objetos");

	
		System.out.println(app.make_a_loan(book, user));
		System.out.println("Pronto");
		
		System.out.println(app.return_a_loan(book));
		System.out.println(app.make_a_loan(book, user));
		
		User u = new User("Joao", u1, "joao123");
		System.out.println(app.add_user(u));
	}

}
