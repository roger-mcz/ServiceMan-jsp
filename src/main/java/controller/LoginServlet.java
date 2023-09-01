package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "/error.jsp";
		String paramUser = request.getParameter("email");
		String paramPassword = request.getParameter("password");
		
		if(paramUser.equals("roger.corpore@gmail.com") && paramPassword.equals("1234")) {
			page = "/menu.jsp";
		}
		
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
