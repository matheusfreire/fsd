package controller;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import usermanager.Application_PortType;
import usermanager.Application_Service;
import usermanager.Application_ServiceLocator;
import loan.services.User;

public class UserCtrl {
	Application_Service service;
	Application_PortType app;
	
	public UserCtrl(){
		this.service = new Application_ServiceLocator();
		try {
			this.app = service.getApplication();
		} catch (ServiceException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
	}

	public void createUser(String name, String rb, String email){
		BigInteger id = new BigInteger(rb);
		User user = new User(name, id, email);
		
		try {
			app.add_user(user);
		} catch (RemoteException e) {
			System.out.println("Erro no Provedor de Serviço: " + e.getMessage());
		}
	}
	
}
