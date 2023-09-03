package controller;

public class LoginController {

	public String getConnection(String user, String password) {
		if(user.equals("roger.corpore@gmail.com") && password.equals("1234")) {
			return "/menu.jsp";
		}
		return "/error.jsp";
	}
}
