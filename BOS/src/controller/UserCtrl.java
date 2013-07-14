package controller;

import model.User;

public class UserCtrl {

	public void createUser(String name, int rb, String email){
		User user = new User(name, rb, email);
	}
	
}
