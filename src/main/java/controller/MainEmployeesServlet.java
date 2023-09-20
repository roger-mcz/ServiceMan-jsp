package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.EmployeeDTO;

/**
 * @author Rogério Oliveira Servlet implementation class LoginServlet
 */

@WebServlet("/Employee")
public class MainEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeController employeeController = new EmployeeController();
       
    public MainEmployeesServlet() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<EmployeeDTO> employeeDTOList = employeeController.findEmployeeList();
		
		/*
		  for (int i = 0; i < employeeDTOList.size(); i++) {			  
	         System.out.println(employeeDTOList.get(i).getName());
	         System.out.println(employeeDTOList.get(i).getEmail());
	         System.out.println(employeeDTOList.get(i).getPhone());
	         System.out.println(employeeDTOList.get(i).getSecondname());
	         System.out.println(employeeDTOList.get(i).getOffice());
	         System.out.println(employeeDTOList.get(i).getRole());
	         System.out.println(employeeDTOList.get(i).getActive()); 
		  }
		  */
		
		request.setAttribute("employeeList", employeeDTOList);
		RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
		rd.forward(request, response);
		
		
	}
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("ipt_name");
		String secondname = request.getParameter("ipt_secondname");
		String email = request.getParameter("ipt_email");
		String phone = request.getParameter("ipt_phone");
		String cpf = request.getParameter("ipt_cpf");
		String office = request.getParameter("ipt_office");
		String role = request.getParameter("ipt_role");
		String active = request.getParameter("chc_active");
		String street = request.getParameter("ipt_street");
		String number = request.getParameter("ipt_number");
		String cep = request.getParameter("ipt_cep");
		String neighborhood = request.getParameter("ipt_neighborhood");
		String city = request.getParameter("ipt_city");
		String state = request.getParameter("ipt_state");
		
		
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
		
		
		
		
		//EmployeeDTO employeeDTOResponse = employeeController.save();
	}
	*/
	
	
	

}
