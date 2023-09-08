package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ConnectionDAO;
import DTO.UserDTO;


/**
 * @author Rogério Oliveira Servlet implementation class LoginServlet
 */

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String accessPage;
		
		UserDTO userDTO = ConnectionDAO.getInstance().validateUser(userName, userPassword);
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
