package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.AdminDBConncet;

/**
 * Servlet implementation class AdminLoanApproveServlet
 */
@WebServlet("/AdminLoanApproveServlet")
public class AdminLoanApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String approve = request.getParameter("value");
		String id = request.getParameter("id");
				
		AdminDBConncet.loanApprove(approve,id);
		
		RequestDispatcher req = request.getRequestDispatcher("/admin");
		req.forward(request, response);

	}

}
