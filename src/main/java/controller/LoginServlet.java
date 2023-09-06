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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String accessPage = "/error.jsp";
		
		UserDTO userDTO = ConnectionDAO.getInstance().validateUser(userName, userPassword);
		if(userDTO != null) {
			accessPage = "/menu.jsp";
		}				

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(accessPage);
		dispatcher.forward(request, response);				
	}


}
