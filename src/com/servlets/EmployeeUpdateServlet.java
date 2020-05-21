package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.EmployeeDBConnect;

@WebServlet("/EmployeeUpdate")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empid = request.getParameter("empid");
		String name = request.getParameter("empname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("empemail");
		String address = request.getParameter("empaddress");
		String phone = request.getParameter("empphone");
		String department = request.getParameter("empdep");
		
		int value = EmployeeDBConnect.updateEmployee(empid, name, nic, email, address, phone, department);
		
		if(value > 0) {
			RequestDispatcher req = request.getRequestDispatcher("/admin");
			req.forward(request, response);
		}
		else {
			//do nothing
		}
		
		
	}

}
