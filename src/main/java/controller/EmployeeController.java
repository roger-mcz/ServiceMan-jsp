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

		String sql = "SELECT * FROM tb_employee";
		ArrayList<EmployeeDTO> employeeDTOList = null;
		
		try {
			ResultSet rs = ConnectionDAO.getInstance().runSQLResultSet(sql);

			String strName, strEmail, strPhone, srtSecondname, strOffice, strRole;
			Boolean boolActive = null;
			employeeDTOList = new ArrayList<EmployeeDTO>();  
			
			while(rs.next()) {
				strName = rs.getString(2);
				strEmail = rs.getString(3);
				strPhone = rs.getString(4);
				srtSecondname = rs.getString(5);
				strOffice = rs.getString(7);
				strRole = rs.getString(8);
				boolActive = Boolean.valueOf(rs.getString(9));
				employeeDTOList.add(new EmployeeDTO(strName, strEmail, strPhone, srtSecondname, strOffice, strRole, boolActive));
			}
					
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionDAO.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
		}
		return employeeDTOList;
	}
	

}
