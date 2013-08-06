package controller;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import login_pkg.Application_PortType;
import login_pkg.Application_Service;
import login_pkg.Application_ServiceLocator;

public class LoginCtrl {

	Application_Service service;
	Application_PortType app;
	
	public LoginCtrl(){
		this.service = new Application_ServiceLocator();
		try {
			this.app = service.getApplication();
		} catch (ServiceException e) {
			System.out.println("Erro ao criar serviço: " + e.getMessage());
		}
	}
	
	public boolean login(String login, String senha) {
		
		try {
			return this.app.login(login, senha);
		} catch (RemoteException e) {
			System.out.println("Erro no Provedor de Serviço: " + e.getMessage());
			return false;
		}
	}

}
