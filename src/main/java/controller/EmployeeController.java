package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.ConnectionDAO;
import DTO.EmployeeDTO;



public class EmployeeController {

	public ArrayList<EmployeeDTO> findEmployeeList() {

		/**
		 * No sql foi requisitada a representação textual do campo boolean, uma vez que o banco internamente salva t/f/y/n.
		 * algumas ferramentas fazem esse cast, o psql não faz, testes apontam que o driver do banco faz. 
		 * pra não criar código p/ tratar, foi explicitado no sql: campo::text.
		 */
		
		ArrayList<EmployeeDTO> employeeDTOList = null;
		String sql = "SELECT name, email, phone, secondname, office, role, active::text"
				+ " FROM tb_employee"
				+ " ORDER BY name";
		
		try {
			ResultSet rs = ConnectionDAO.getInstance().runSQLResultSet(sql);
			String strName, strEmail, strPhone, srtSecondname, strOffice, strRole;
			Boolean boolActive = null;
			employeeDTOList = new ArrayList<EmployeeDTO>();  			
			
			while(rs.next()) {
				strName = rs.getString(1);
				strEmail = rs.getString(2);
				strPhone = rs.getString(3);
				srtSecondname = rs.getString(4);
				strOffice = rs.getString(5);
				strRole = rs.getString(6);
				boolActive = Boolean.valueOf(rs.getString(7));
			//	System.out.println("Nome:" + strName + ", active:" + rs.getString(7));
				employeeDTOList.add(new EmployeeDTO(strName, strEmail, strPhone, srtSecondname, strOffice, strRole, boolActive));
			}					
			
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return employeeDTOList;
	}
	

}
