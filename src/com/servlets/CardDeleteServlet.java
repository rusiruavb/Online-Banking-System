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

@WebServlet("/CardDeleteServlet")
public class CardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		String accNo = request.getParameter("id");
		String nic = request.getParameter("nic");
		boolean isTrue;
		boolean cardCheck;
		double accountBalance;
		
		isTrue = CardDBConnect.deleteCardDetails(accNo);
		
		if (isTrue == true) {
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
