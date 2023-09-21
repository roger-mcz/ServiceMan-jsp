package BO;

import DAO.LoginDAO;
import DTO.UserDTO;

public class LoginBO {

	LoginDAO loginDAO = new LoginDAO() ;
	
	public UserDTO validateUser(String userName, String  userPassword) {
		
		return loginDAO.validateUser(userName, userPassword);
		
	}
}
