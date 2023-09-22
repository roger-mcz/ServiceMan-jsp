package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.UserDTO;
import controller.LoginControllerServlet;

/**
 * @author Rogério Oliveira Classe para conexão ao prostgres 11, ver. do jar: 42.5.0
 * 
 */

public class ConnectionDB {

	private static ConnectionDB instance;
	private Connection connection;

	public static ConnectionDB getInstance() {
		if (instance == null) {
			instance = new ConnectionDB();
		}
		return instance;

	}
	
	
	public Connection getConnection() {
		return connection;
	}
	

	public ConnectionDB() {
		String dbUrl = "jdbc:postgresql://postgres14:5432/serviceman";
		String dbUser = "serviceman";
		String dbPassword = "p22ssw00rd";

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex);
		}
	}







	

	
	
}
