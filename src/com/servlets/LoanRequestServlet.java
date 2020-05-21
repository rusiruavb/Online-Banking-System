package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.CustomerDBConncet;


@WebServlet("/LoanRequestServlet")
public class LoanRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("accNo");
		String name = request.getParameter("name");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String loanAmount = request.getParameter("amount");
		String description = request.getParameter("description");
		boolean isSuccess;
		
		try {
			isSuccess = CustomerDBConncet.insertLoanDetails(userId, name, nic, email, phone, salary, loanAmount, description);
			
			if (isSuccess = true) {
				response.sendRedirect("customerdetails");
			}
			else {
				response.sendRedirect("customerdetails");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in loan servlet");
		}
	}

}
