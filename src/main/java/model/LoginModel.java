package model;

import controller.LoginController;

public class LoginModel {

	public LoginModel() {
		super();
	}

	
	LoginController controller;
	
	public String getConnection(String user, String password) {
//		return controller.getConnection(user, password);
		return "/error.jsp";
	}
}
