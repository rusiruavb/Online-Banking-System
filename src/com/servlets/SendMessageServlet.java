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

@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accNumber = request.getParameter("id");
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		boolean isTrue;
		boolean cardCheck;
		double accountBalance;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		isTrue = CustomerDBConncet.sendMessage(accNumber, name, email, message);
		
		if(isTrue == true) {
			response.sendRedirect("customerdetails");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Somthing Happened!!! Update Your date is no success');");
			//out.println("location='insertcustomer.jsp';");
			out.println("</script>");
			response.sendRedirect("customerdetails");
		}
		
		}
		
	}

