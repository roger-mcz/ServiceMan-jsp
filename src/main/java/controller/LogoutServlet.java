package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Rog�rio Oliveira Servlet implementation class Logout
 */

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public LogoutServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String accessPage = "/index.jsp";
		
		if(session != null) {
			session.removeAttribute("userDTO");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(accessPage);
			dispatcher.forward(request, response);
		}
		
	}

}
