package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.EmployeeDBConnect;

@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("empid");
		
		int deleteValue = EmployeeDBConnect.deleteEmployee(id);
		
		if(deleteValue > 0) {
			RequestDispatcher req = request.getRequestDispatcher("/admin");
			req.forward(request, response);
		}
		else {
			//do nothing
		}
	}

}
