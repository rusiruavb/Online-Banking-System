package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.CustomerDBConncet;

@WebServlet("/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		String id = request.getParameter("id");

		boolean isSuccess;
		
		isSuccess = CustomerDBConncet.deletecustomer(id);
		
		if(isSuccess == true) {
			RequestDispatcher req = request.getRequestDispatcher("insertcustomer.jsp");
			req.forward(request, response);
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Somthing Happened!!! Delete account process not success');");
			out.println("location='customerlogin.jsp';");
			out.println("</script>");
		}
	}

}
