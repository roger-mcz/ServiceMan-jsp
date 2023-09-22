package BO;

import java.util.ArrayList;

import DAO.EntityDAO;
import DTO.EmployeeDTO;

public class EntityBO {

	/**
	 * @author Rog�rio Oliveira Servlet implementation class Logout
	 */
		
	
	public ArrayList<EmployeeDTO> list(){
		
		EntityDAO entityDAO = new EntityDAO();
		StringBuilder sql = new StringBuilder();

		/**
		 * No sql foi requisitada a representa��o textual do campo boolean, uma vez que o banco internamente salva t/f/y/n.
		 * algumas ferramentas fazem esse cast, o psql n�o faz, testes sugerem que o driver do banco n�o faz. 
		 * Pra n�o criar c�digo p/ tratar, foi explicitado no sql: campo::text.
		 */
		sql.append("SELECT id, name, email, phone, secondname, cpf, office, role, active::text, street, number, cep, neighborhood, city, state");
		sql.append(" FROM tb_employee");
		
		return entityDAO.list(sql.toString());
	}
	
}
