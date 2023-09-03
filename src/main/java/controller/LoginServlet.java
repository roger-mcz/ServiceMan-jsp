package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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


	//@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String accessPage = "";
//		LoginModel loginModel = null;
//		accessPage = loginModel.getConnection(user, password);
				
		String dbUrl = "jdbc:postgresql://postgres14:5432/serviceman";
		String dbUser = "serviceman";
		String dbPassword = "p22ssw00rd";
		
		try {
			Class.forName("org.postgresql.Driver");	
			Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = connection.prepareStatement(
					"select username from tb_login where username=? and password=?"
					);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO, "Acesso realizado com sucesso: " + userName);
				accessPage = "/menu.jsp";
			} else {
				Logger.getLogger(LoginServlet.class.getName()).log(Level.WARNING, "FAlha na tentativa de acesso: " + userName);
				accessPage = "/error.jsp";
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Falha de SQL: " + ex.getMessage());
			accessPage = "/error.jsp";
		} catch (RuntimeException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Falha interna - RuntimeException");
			accessPage = "/error.jsp";
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Erro ao acessar o driver: " + ex.getMessage());
			accessPage = "/error.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(accessPage);
		dispatcher.forward(request, response);				
	}


}
