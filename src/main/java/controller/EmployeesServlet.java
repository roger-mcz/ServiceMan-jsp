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

@WebServlet("/Employees")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeController employeeController = new EmployeeController();
       
    public EmployeesServlet() {
        super();
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<EmployeeDTO> employeeDTOList = employeeController.findEmployeeList();
		/*
		 * for (int i = 0; i < employeeDTOList.size(); i++) {
		 * System.out.println(employeeDTOList.get(i).getName());
		 * System.out.println(employeeDTOList.get(i).getEmail());
		 * System.out.println(employeeDTOList.get(i).getPhone());
		 * System.out.println(employeeDTOList.get(i).getSecondname());
		 * System.out.println(employeeDTOList.get(i).getOffice());
		 * System.out.println(employeeDTOList.get(i).getRole());
		 * System.out.println(employeeDTOList.get(i).getActive()); }
		 */
		
		request.setAttribute("employeeList", employeeDTOList);
		RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
		rd.forward(request, response);
		
	}
	
	
	

}
