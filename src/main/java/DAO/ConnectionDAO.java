package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.UserDTO;
import controller.LoginServlet;

/**
 * @author Rogério Oliveira Classe para conexão ao prostgres 11, ver. do jar: 42.5.0
 * 
 */

public class ConnectionDAO {

	private static ConnectionDAO instance;
	private Connection connection;

	public static ConnectionDAO getInstance() {
		if (instance == null) {
			instance = new ConnectionDAO();
		}
		return instance;

	}

	private ConnectionDAO() {
		String dbUrl = "jdbc:postgresql://postgres14:5432/serviceman";
		String dbUser = "serviceman";
		String dbPassword = "p22ssw00rd";

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex);
		}
	}

	public Object runSQL(String sql, Object[] args) {
		return runSQL(sql, args, false);
	}

	public ResultSet runSQLResultSet(String sql, Object[] args) {
		return (ResultSet) runSQL(sql, args, true);
	}

	public Object runSQL(String sql, Object[] args, Boolean hasReturn) {
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			Object resultSQL = null;
			if (hasReturn) {
				resultSQL = ps.executeQuery();
			} else {
				resultSQL = ps.execute();
			}

			return resultSQL;

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			return null;
		}
	}

	
	public UserDTO validateUser(String userName, String userPassword) {
		
		String sqlCheckUser = "SELECT tb_employee.id, tb_employee.name"
						+ " FROM tb_employee" + " INNER JOIN tb_user" + "  ON tb_employee.id = tb_user.idemployee"
						+ " WHERE tb_employee.email=? AND password=?";
		UserDTO userDTO = null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(sqlCheckUser);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst()) {
				userDTO = new UserDTO();
				while(rs.next()) {
					userDTO.setId(Long.parseLong(rs.getString("id")));
					userDTO.setName(rs.getString("name"));
				}
				userDTO.setEmail(userName);
				
				Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO,
						"Acesso realizado com sucesso: " + userDTO.getName());
			} else {
				Logger.getLogger(LoginServlet.class.getName()).log(Level.WARNING,
						"Falha na tentativa de acesso: " + userName);
				//connection.close();
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return userDTO;
	}
	
	
	
	
	
	
	//legado:
	/*
	public UserDTO makeConnection(String userName, String userPassword) {

		String dbUrl = "jdbc:postgresql://postgres14:5432/serviceman";
		String dbUser = "serviceman";
		String dbPassword = "p22ssw00rd";
		UserDTO userDTO = null;

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			PreparedStatement ps = connection.prepareStatement("SELECT tb_employee.id, tb_employee.name"
					+ " FROM tb_employee" + " INNER JOIN tb_user" + "   ON tb_employee.id = tb_user.idemployee"
					+ " WHERE tb_employee.email=? AND password=?");
//		"select username, email from tb_employee where username=? and password=?");

			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();

			userDTO = new UserDTO();
			userDTO.setId(Long.parseLong(rs.getString("id")));
			userDTO.setName(rs.getString("name"));
			userDTO.setEmail(userName);

			if (rs.next()) {
				Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO,
						"Acesso realizado com sucesso: " + userDTO.getName());
				// accessPage = "/menu.jsp";
			} else {
				Logger.getLogger(LoginServlet.class.getName()).log(Level.WARNING,
						"Falha na tentativa de acesso: " + userName);
				// accessPage = "/error.jsp";
			}

		} catch (SQLException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Falha de SQL: " + ex.getMessage());
			// accessPage = "/error.jsp";
		} catch (RuntimeException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, "Falha interna - RuntimeException");
			// accessPage = "/error.jsp";
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE,
					"Erro ao acessar o driver: " + ex.getMessage());
			// accessPage = "/error.jsp";
		}
		return userDTO;
	}
	*/
	
	
}
