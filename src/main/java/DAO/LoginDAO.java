package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.UserDTO;
import controller.LoginControllerServlet;

public class LoginDAO {

	ConnectionDB connectionDB = null;
	
	
	public UserDTO validateUser(String userName, String userPassword) {
		
		String sqlCheckUser = "SELECT tb_employee.id, tb_employee.name"
						+ " FROM tb_employee" + " INNER JOIN tb_user" + "  ON tb_employee.id = tb_user.idemployee"
						+ " WHERE tb_employee.email=? AND password=?";
		UserDTO userDTO = null;		
	
		try {
			
			PreparedStatement ps = connectionDB.getInstance().getConnection().prepareStatement(sqlCheckUser);
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
				
				Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.INFO,
						"Acesso realizado com sucesso: " + userDTO.getName());
			} else {
				Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.WARNING,
						"Falha na tentativa de acesso: " + userName);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return userDTO;
	}

}
