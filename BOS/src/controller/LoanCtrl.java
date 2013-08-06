package controller;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import usermanager.Application_PortType;
import usermanager.Application_Service;
import usermanager.Application_ServiceLocator;

public class LoanCtrl {
	Application_Service service;
	Application_PortType app;
	
	public LoanCtrl(){
		this.service = new Application_ServiceLocator();
		try {
			this.app = service.getApplication();
		} catch (ServiceException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
	}
	
	public boolean makeLoan(String user_id, String book_id){
		BigInteger user = new BigInteger(user_id);
		BigInteger book = new BigInteger(book_id);
		
		try {
			if(app.make_a_loan(book, user).equals(new BigInteger("0")))
				return true;
		} catch (RemoteException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
		return false;
	}
	
	public boolean returnLoan(String book_id){
		BigInteger book = new BigInteger(book_id);
		
		try {
			if(app.return_a_loan(book).equals(new BigInteger("0")))
				return true;
		} catch (RemoteException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
		return false;
	}
}