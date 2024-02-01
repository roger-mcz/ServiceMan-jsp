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
import javax.servlet.http.HttpSession;

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
	String employeeId;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		action = request.getParameter("action");
		employeeId = request.getParameter("employeeid");
		LogMaker log = new LogMaker();

        if (action != null){        	
            if (action.equals("read")) {
				entityDTOList = findAllEntity();
				accessPage = "employees.jsp";
            }
            else if(action.equals("create")) {
				accessPage = "createemployee.jsp";
            }
            else if(action.equals("update")) {
				employeeDTO = findEntityById(employeeId);
				System.out.println("employeeDTO no controller:" + employeeDTO);
				//enviar o employeeDTO p/ pag. update...
    			accessPage = "updateemployee.jsp";
            }
            else if(action.equals("delete")) {
                System.out.println("delete!");
                System.out.println("employeeId: " + employeeId);
            }
        }
        else{
            System.out.println("action request inválida!");
        }			
		RequestDispatcher rd = request.getRequestDispatcher(accessPage);
		request.setAttribute("employeeList", entityDTOList);
		rd.forward(request, response);
	}
	

	protected ArrayList<EmployeeDTO> findAllEntity() {
		return entityBO.findAllEntity();
	}

	
	protected EmployeeDTO findEntityById(String id) {	
		return entityBO.findEntityById(id);
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
		
        if (action != null){
            if (action.equals("create")) {
            	intResult = entityBO.create(makeEntityDTO(request));
    			if (intResult == 1) {
    				operateResult = "Gravação realizada!";
    				log.make(Level.INFO.toString(), "Gravado com sucesso:" + employeeDTO.getEmail());
    				clearEntityDTOList();
    				entityDTOList = findAllEntity();
    				accessPage = "createemployee.jsp";
    			}else {
    				System.out.println("Falha na Gravação!");
    				log.make(Level.WARNING.toString(), "Acesso negado:" + employeeDTO.getEmail());
    				accessPage = "error.jsp";
    			}
            }else if(action.equals("update")) {
            	System.out.println("update!");
    			//intResult = entityBO.update(makeEntityDTO(request)); - pegar o id e 
    			//accessPage = "updateemployee.jsp";

            }else if(action.equals("read")) {
                System.out.println("read!");

            }else if(action.equals("delete")) {
                System.out.println("delete!");                
            }
        }else{
            System.out.println("action request inválida!");
        }
				
		RequestDispatcher rd = request.getRequestDispatcher(accessPage);
		rd.forward(request, response);
	}

	/*
	 * protected void doPut(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * int intResult = 0; LogMaker log = new LogMaker(); String action =
	 * request.getParameter("action");
	 * 
	 * employeeId = request.getParameter("employeeid");
	 * 
	 * 
	 * if (action.equals("update")) {
	 * 
	 * System.out.println("employeeid:" + employeeId);
	 * 
	 * intResult = entityBO.create(makeEntityDTO(request)); if (intResult == 1) {
	 * operateResult = "Gravação realizada!"; log.make(Level.INFO.toString(),
	 * "Gravado com sucesso:" + employeeDTO.getEmail()); clearEntityDTOList();
	 * entityDTOList = listEntity(); accessPage = "updateemployee.jsp"; }else {
	 * System.out.println("Falha na Gravação!"); log.make(Level.WARNING.toString(),
	 * "Acesso negado:" + employeeDTO.getEmail()); accessPage = "error.jsp"; } } }
	 */

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
