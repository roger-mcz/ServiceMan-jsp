package BO;

import java.util.ArrayList;

import DAO.EntityDAO;
import DTO.EmployeeDTO;

public class EntityBO {

	/**
	 * @author Rogério Oliveira Servlet implementation class Logout
	 */
		
	EntityDAO entityDAO = new EntityDAO();
	
	public ArrayList<EmployeeDTO> list(){
		StringBuilder sql = new StringBuilder();

		/**
		 * No sql foi requisitada a representação textual do campo boolean, uma vez que o banco internamente salva t/f/y/n.
		 * algumas ferramentas fazem esse cast, o psql não faz, testes sugerem que o driver do banco não faz. 
		 * Pra não criar código p/ tratar, foi explicitado no sql: campo::text.
		 */
		sql.append("SELECT id, name, email, phone, secondname, cpf, office, role, active::text, street, number, cep, neighborhood, city, state");
		sql.append(" FROM tb_employee");
		sql.append(" ORDER BY name");
		return entityDAO.list(sql.toString());
	}
	
	
	public int create(EmployeeDTO employeeDTO) {
		StringBuilder sql = new StringBuilder();
		String sqlParameters =  
				"'" + employeeDTO.getName() + "', " +  
				"'" + employeeDTO.getEmail() + "', " +
				"'" + employeeDTO.getPhone() + "', " +
				"'" + employeeDTO.getSecondname() + "', " +
				"'" + employeeDTO.getCpf() + "', " +
				"'" + employeeDTO.getOffice() + "', " +
				"'" + employeeDTO.getRole() + "', " +
				employeeDTO.getActive() + ", " +
				"'" + employeeDTO.getStreet() + "', " +
				employeeDTO.getNumber() + ", " +
				"'" + employeeDTO.getCep() + "', " +
				"'" + employeeDTO.getNeighborhood() + "', " +
				"'" + employeeDTO.getCity() + "', " +
				"'" + employeeDTO.getState() + "'";		
		
//		sql.append("INSERT INTO tb_employee (name, email, phone, secondname, cpf, office, role, active, street, number, cep, neighborhood, city, state) VALUES ('nome1', 'nome1@mail.com', '999999999', 'sobre1', '99999999', 'analista', 'n9', TRUE, 'rua 99', 2, '999999999', 'centro', 'mcz', 'al')");
		sql.append("INSERT INTO");
		sql.append(" tb_employee (name, email, phone, secondname, cpf, office, role, active, street, number, cep, neighborhood, city, state)");
		sql.append(" VALUES (" + sqlParameters + ")");
		return entityDAO.create(sql.toString());
	}
	
	
	
	
}
