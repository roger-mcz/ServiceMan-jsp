package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.EntityBO;
import DTO.EmployeeDTO;
import util.LogMaker;

/**
 * @author Rogério Oliveira Servlet implementation class Logout
 */

@WebServlet("/employee")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeControllerServlet() {
		super();
	}

	ArrayList<EmployeeDTO> entityDTOList = null;
	EmployeeDTO employeeDTO = null;
	String accessPage;
	String action = null;
	String operateResult;
	String attributeMessage;
	EntityBO entityBO = new EntityBO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//action = null;
		action = request.getParameter("action");
		

		if(action != null) {
			clearEntityDTOList();
			if (action.equals("read")) {
				entityDTOList = listEntity();
				accessPage = "employees.jsp";
			}else if (action.equals("create")) {
				accessPage = "createemployee.jsp";
			}			
			else {
				System.out.println("Falha de action do JSP:" + action);
				accessPage = "error.jsp";
				attributeMessage = "validateMessage";
			}		
		}
		RequestDispatcher rd = request.getRequestDispatcher(accessPage);
		request.setAttribute("employeeList", entityDTOList);
		rd.forward(request, response);
	}

	protected ArrayList<EmployeeDTO> listEntity() {
		return entityBO.list();
	}

	protected void clearEntityDTOList() {
		if (entityDTOList != null) {
			entityDTOList.clear();
		}
	}

	protected EmployeeDTO makeEntityDTO(HttpServletRequest request) {

		employeeDTO = new EmployeeDTO();
		Boolean boolActive = false;
		employeeDTO.setId(999L);
		employeeDTO.setName(request.getParameter("ipt_name"));
		employeeDTO.setEmail(request.getParameter("ipt_email"));
		employeeDTO.setPhone(request.getParameter("ipt_phone"));
		employeeDTO.setSecondname(request.getParameter("ipt_secondname"));
		employeeDTO.setCpf(request.getParameter("ipt_cpf"));
		employeeDTO.setOffice(request.getParameter("ipt_office"));
		employeeDTO.setRole(request.getParameter("ipt_role"));

		/*
		 * input type="checkbox" retorna: on/null
		 */
		if (request.getParameter("chk_active") != null) {
			boolActive = true;
		}
		employeeDTO.setActive(boolActive);
		employeeDTO.setStreet(request.getParameter("ipt_street"));
		employeeDTO.setNumber(Integer.valueOf(request.getParameter("ipt_number")));
		employeeDTO.setCep(request.getParameter("ipt_cep"));
		employeeDTO.setNeighborhood(request.getParameter("ipt_neighborhood"));
		employeeDTO.setCity(request.getParameter("ipt_city"));
		employeeDTO.setState(request.getParameter("ipt_state"));
		return employeeDTO;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int intResult = 0;
		LogMaker log = new LogMaker();
		String action = request.getParameter("action");

		if (action.equals("create")) {
			
			intResult = entityBO.create(makeEntityDTO(request));
			if (intResult == 1) {
				operateResult = "Gravação realizada!";
				log.make(Level.INFO.toString(), "Gravado com sucesso:" + employeeDTO.getEmail());
				clearEntityDTOList();
				entityDTOList = listEntity();
				accessPage = "createemployee.jsp";
			}else {
				System.out.println("Falha na Gravação!");
				log.make(Level.WARNING.toString(), "Acesso negado:" + employeeDTO.getEmail());
				accessPage = "error.jsp";
			}	
		}


		
		
		RequestDispatcher rd = request.getRequestDispatcher(accessPage);
		rd.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
