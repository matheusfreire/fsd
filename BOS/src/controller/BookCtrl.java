package controller;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import description.Application_PortType;
import description.Application_Service;
import description.Application_ServiceLocator;
import Description.services.Book;
import Description.services.Description;

public class BookCtrl {

	Application_Service service;
	Application_PortType app;
	
	public BookCtrl(){
		this.service = new Application_ServiceLocator();
		try {
			this.app = service.getApplication();
		} catch (ServiceException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
	}
	
	public void addTitle(String isbn, String name, String author){
		BigInteger id = new BigInteger(isbn);
		Description description = new Description(id, name, author);
		
		try {
			app.add_description(description);
			
		} catch (RemoteException e) {
			System.out.println("Erro no Provedor de Serviço: " + e.getMessage());
		}
	}
	
	public boolean verifyBookByName(String name){
		Description b;
		try {
			b = app.get_description_by_name(name);
			if(b==null)
				return false;
			return true;
		} catch (RemoteException e) {
			System.out.println("Erro no Provedor de Serviço: " + e.getMessage());
			return false;
		}
		
	}
	
	public void addABookToTitle(int book_id, String isbn){
		BigInteger serial = new BigInteger(String.valueOf(book_id));
		
		Description description;
		try {
			description = app.get_description_by_isbn(isbn);
			Book book = new Book(true, description, serial);
			app.add_description(description);
			app.add_book(book);
		} catch (RemoteException e1) {
			System.out.println("Erro no Provedor de Serviço, Titulo nao existe: " + e1.getMessage());
		}
		
	
	}
	
}
