package com.servlets;

import com.dbConnect.*;
import com.javaClasses.Card;
import com.javaClasses.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		String id = request.getParameter("id");
		String nic = request.getParameter("nic");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String address = request.getParameter("address");   
	    String phone = request.getParameter("phone");
	    String dob = request.getParameter("dob");
	    String gender =  request.getParameter("gender");
	    String password = request.getParameter("password");
	    boolean cardCheck;
	    double accountBalance;
		
		int updateValue = CustomerDBConncet.updatecustomer(id,nic,name,email,address,phone,dob,gender,password);
		
		if(updateValue > 0) {
			response.sendRedirect("customerdetails");	
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Somthing Happened!!! Update Your date is no success');");
			out.println("</script>");
			response.sendRedirect("customerdetails");
		}
	}

}
