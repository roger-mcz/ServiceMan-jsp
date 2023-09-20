package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EmployeeDTO;

/**
 * @author Rogério Oliveira Servlet implementation class Logout
 */

@WebServlet("/CreateEmployee")
public class CrudEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrudEmployeeServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean boolActive = Boolean.parseBoolean(request.getParameter("chc_active"));
		Integer intNumber = Integer.parseInt(request.getParameter("ipt_number"));		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setId(999L);
		employeeDTO.setName(request.getParameter("ipt_name"));
		employeeDTO.setSecondname(request.getParameter("ipt_secondname"));
		employeeDTO.setEmail(request.getParameter("ipt_email"));
		employeeDTO.setPhone(request.getParameter("ipt_phone"));
		employeeDTO.setCpf(request.getParameter("ipt_cpf"));
		employeeDTO.setOffice(request.getParameter("ipt_office"));
		employeeDTO.setRole(request.getParameter("ipt_role"));
		employeeDTO.setActive(boolActive);
		employeeDTO.setStreet(request.getParameter("ipt_street"));
		employeeDTO.setNumber(intNumber);
		employeeDTO.setCep(request.getParameter("ipt_cep"));
		employeeDTO.setNeighborhood(request.getParameter("ipt_neighborhood"));
		employeeDTO.setCity(request.getParameter("ipt_city"));
		employeeDTO.setState(request.getParameter("ipt_state"));
		
		System.out.println(employeeDTO);
		
		
	}

}
