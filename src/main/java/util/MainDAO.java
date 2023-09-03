package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rogério Oliveira Classe para conexão ao prostgres 11, ver. do jar:
 *         42.5.0
 * 
 */

public class MainDAO {

	private static MainDAO instance;
	private Connection connection;
	private final String url = "jdbc:postgresql://localhost:5432/teste";
	private final String user = "postgres";
	private final String password = "p22ssw00rd";

	public static MainDAO getInstance() {
		if (instance == null) {
			instance = new MainDAO();
		}
		return instance;
	}

	private MainDAO() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// Logger.getLogger(MainDAO.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex);
		}
	}

	public Object execute(String sql, Object[] args) {
		return execute(sql, args, false);
	}

	public ResultSet executeQuery(String sql, Object[] args) {
		return (ResultSet) execute(sql, args, true);
	}
	
	
	private Object execute(String sql, Object[] args, boolean isQuery){
        try {
               PreparedStatement pstm = connection.prepareStatement(sql);

               for (int i =0; i< args.length; i++){
                      pstm.setObject(i+1, args[i]);
               }

               Object toReturn = null;
               if (isQuery){
                      toReturn = pstm.executeQuery();
               }else{
                      toReturn = pstm.execute();
               }

               return toReturn;

        } catch (SQLException e) {
               e.printStackTrace();
               return null;
        }
  }
	
	
	

}
