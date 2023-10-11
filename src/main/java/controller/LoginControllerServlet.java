package controller;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BO.LoginBO;
import DTO.UserDTO;
import util.LogMaker;


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
		LogMaker log = new LogMaker();
		
		String statusMessage = "";
		HttpSession session = request.getSession();
		
		if(userDTO != null) {			
			statusMessage = "Bem vindo " + userDTO.getName() + " " + userDTO.getSecondName();
			session.setAttribute("statusmessage", statusMessage);
//			request.setAttribute("validateMessage", "Bem vindo " + userDTO.getName() + " !");
			log.make(Level.INFO.toString(), "Acesso autorizado:" + userDTO.getEmail());			
			accessPage = "/menu.jsp";
			
		} else {
			statusMessage = "Falha de acesso: E-mail / Senha inválido(s)!";
			session.setAttribute("statusmessage", statusMessage);
//			request.setAttribute("validateMessage", "Falha de acesso: E-mail / Senha inválido(s)!");
			log.make(Level.WARNING.toString(), "Acesso negado:" + userName);
			accessPage = "/error.jsp";			
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(accessPage);
		dispatcher.forward(request, response);				
	}


}
