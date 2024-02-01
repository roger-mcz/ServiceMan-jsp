package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.EmployeeDTO;
import DTO.UserDTO;

/**
 * @author Rogério Oliveira Classe para conexão ao prostgres 11, ver. do jar: 42.5.0
 * 
 */

public class EntityDAO {

	ConnectionDB connectionDB = new ConnectionDB();
	EmployeeDTO employeeDTO = null;
	ArrayList<EmployeeDTO> employeeDTOList = new ArrayList<>();
	
	public ArrayList<EmployeeDTO> findAllEntity(String sql){
		
		try {
			PreparedStatement ps = connectionDB.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO(); //tem q criar aqui p/ gerar um novo obj a ser adicionado (.add)
				employeeDTO.setId(Long.parseLong(rs.getString("id")));
				employeeDTO.setName(rs.getString("name"));
				employeeDTO.setSecondname(rs.getString("secondname"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone(rs.getString("phone"));
				employeeDTO.setCpf(rs.getString("cpf"));
				employeeDTO.setOffice(rs.getString("office"));
				employeeDTO.setRole(rs.getString("role"));
				employeeDTO.setActive(Boolean.valueOf(rs.getString("active")));
				employeeDTO.setStreet(rs.getString("street"));
				employeeDTO.setNumber(Integer.valueOf(rs.getString("number")));
				employeeDTO.setCep(rs.getString("cep"));
				employeeDTO.setNeighborhood(rs.getString("neighborhood"));
				employeeDTO.setCity(rs.getString("city"));
				employeeDTO.setState(rs.getString("state"));
				employeeDTOList.add(employeeDTO);
			}			
//			for (EmployeeDTO employeeDTO : employeeDTOList) {
//				System.out.println("employeeDTO item:" + employeeDTO);
//			}
		} catch (Exception ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}		
	return employeeDTOList;	
	}

	
	public EmployeeDTO findEntityById(String sql) {
		
		try {
			PreparedStatement ps = connectionDB.getInstance().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				employeeDTO = new EmployeeDTO(); //tem q criar aqui p/ gerar um novo obj a ser adicionado (.add)
				employeeDTO.setId(Long.parseLong(rs.getString("id")));
				employeeDTO.setName(rs.getString("name"));
				employeeDTO.setSecondname(rs.getString("secondname"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone(rs.getString("phone"));
				employeeDTO.setCpf(rs.getString("cpf"));
				employeeDTO.setOffice(rs.getString("office"));
				employeeDTO.setRole(rs.getString("role"));
				employeeDTO.setActive(Boolean.valueOf(rs.getString("active")));
				employeeDTO.setStreet(rs.getString("street"));
				employeeDTO.setNumber(Integer.valueOf(rs.getString("number")));
				employeeDTO.setCep(rs.getString("cep"));
				employeeDTO.setNeighborhood(rs.getString("neighborhood"));
				employeeDTO.setCity(rs.getString("city"));
				employeeDTO.setState(rs.getString("state"));
			}
			//System.out.println(employeeDTO);
			
		} catch (Exception ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return employeeDTO;	
	}
	
	
	
	public int create(String sql) {
		int intResult = 0;
		try {
			PreparedStatement ps = connectionDB.getInstance().getConnection().prepareStatement(sql);
/*
			ps.setString(1, employeeDTO.getName());
			ps.setString(2, employeeDTO.getEmail());
			ps.setString(3, employeeDTO.getPhone());
			ps.setString(4, employeeDTO.getSecondname());
			ps.setString(5, employeeDTO.getCpf());
			ps.setString(6, employeeDTO.getOffice());
			ps.setString(7, employeeDTO.getRole());
//			ps.setString(8, employeeDTO.getActive().toString());	//sql exception
			ps.setBoolean(8, employeeDTO.getActive());
			ps.setString(9, employeeDTO.getStreet());
//			ps.setString(10, employeeDTO.getNumberString());
			ps.setInt(10, employeeDTO.getNumber());
			ps.setString(11, employeeDTO.getCep());
			ps.setString(12, employeeDTO.getNeighborhood());
			ps.setString(13, employeeDTO.getCity());
			ps.setString(14, employeeDTO.getState());
			System.out.println("ps.toString: " + ps.toString());
		*/	
			intResult = ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		} catch (Exception ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return intResult;

	}
	
	
	
	
	
	
	
	/*

	public Object runSQL(String sql, Object[] args) {
		return runSQL(sql, args, false);
	}

//	public ResultSet runSQLResultSet(String sql, Object[] args) {
//		return (ResultSet) runSQL(sql, args, true);
//	}

	public ResultSet runSQLResultSet(String sql) {
		return (ResultSet) runSQL(sql);
		
	}
	

	public Object runSQL(String sql) {
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			Object resultSQL = null;
			resultSQL = ps.executeQuery();
			return resultSQL;

		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			return null;
		}
		
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
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
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
				
				Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.INFO,
						"Acesso realizado com sucesso: " + userDTO.getName());
			} else {
				Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.WARNING,
						"Falha na tentativa de acesso: " + userName);
				//connection.close();
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(EntityDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return userDTO;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	*/
	
}
