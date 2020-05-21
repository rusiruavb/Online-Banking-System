package com.servlets;

import com.javaClasses.*;
import com.dbConnect.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardInsertServlet")
public class CardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accId = request.getParameter("id");
		String name = request.getParameter("name");
		String nic = request.getParameter("nic");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String occupation = request.getParameter("occu");
		String salary = request.getParameter("salary");
		String cardType = request.getParameter("ctype");
		String description = request.getParameter("des");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		boolean isSuccess;
		boolean cardCheck;
		double accountBalance;
		
		isSuccess = CardDBConnect.insertCardDetails(accId, name, nic, address, email, phone, occupation, salary, cardType, description);
		
		if(isSuccess == true) {
			response.sendRedirect("customerdetails");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Somthing Happened!!! Your NIC is already in the system');");
			out.println("location='requestcard.jsp';");
			out.println("</script>");
			response.sendRedirect("customerdetails");
		}
	}

}
