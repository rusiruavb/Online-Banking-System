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

@WebServlet("/CardUpdateServlet")
public class CardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		String accNo = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String salary = request.getParameter("salary");
		String occupation = request.getParameter("occu");
		String type = request.getParameter("ctype");
		boolean isTrue;
		boolean cardCheck;
		double accountBalance;
		
		isTrue = CardDBConnect.updateCardDetails(accNo, name, nic, address, email, phone, occupation, salary, type);
		
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
