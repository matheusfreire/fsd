package controller;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import Description.services.Book;
import Description.services.Description;
import description.Application_PortType;
import description.Application_Service;
import description.Application_ServiceLocator;

public class Test {

	public static void main(String[] args) throws ServiceException, RemoteException {
		BigInteger isbn = new BigInteger("6");
		BigInteger general = new BigInteger("9");
		Application_Service service = new Application_ServiceLocator();
		Application_PortType app = service.getApplication();
		
		Description description = app.get_description_by_isbn("1");
		Description d = new Description(isbn, "ASd", "ds");
		
		System.out.println(app.add_description(d));
		Description b = app.get_description_by_isbn("2");
		Book book = new Book(true, description, general);
		System.out.println(app.add_book(book));
		System.out.println(b.getAuthor());
		
		System.out.println(description.getAuthor());
	}

}
