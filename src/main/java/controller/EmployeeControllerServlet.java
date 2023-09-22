package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BO.EntityBO;
import DTO.EmployeeDTO;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EntityBO entityBO = new EntityBO();
		String action = request.getParameter("action");
		if (action.equals("list")) {
			//entityDTOList = new ArrayList<EmployeeDTO>();
			entityDTOList = entityBO.list();
		} 
		else {
			System.out.println("Falha de action do JSP:" + action);
		}
			
		request.setAttribute("employeeList", entityDTOList);
		RequestDispatcher rd = request.getRequestDispatcher("employees.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
