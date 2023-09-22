package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.LoginBO;
import DAO.EntityDAO;
import DTO.UserDTO;


/**
 * @author Rogério Oliveira Servlet implementation class LoginControllerServlet
 */

@WebServlet("/Login")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControllerServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		LoginBO loginBO = new LoginBO();
		String accessPage;

		UserDTO userDTO = loginBO.validateUser(userName, userPassword);
		
		if(userDTO != null) {
			request.setAttribute("validateMessage", "Bem vindo " + userDTO.getName() + " !");
			accessPage = "/menu.jsp";
		} else {
			request.setAttribute("validateMessage", "E-mail / Senha inválido(s)!");
			accessPage = "/error.jsp";			
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(accessPage);
		dispatcher.forward(request, response);				
	}


}
