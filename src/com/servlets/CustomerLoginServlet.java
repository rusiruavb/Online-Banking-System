package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbConnect.CardDBConnect;
import com.dbConnect.CustomerDBConncet;
import com.javaClasses.Card;
import com.javaClasses.Customer;

@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		
		String nic = request.getParameter("nic");
		String password = request.getParameter("password");
		boolean cardCheck;
		double accountBalance;
		
		try {
			
			boolean isSuccess = CustomerDBConncet.validateCustomer(nic, password);
	        
	        if(isSuccess == true) {
	        	HttpSession session=request.getSession();  
	        	session.setAttribute("nic", nic);
	        	
	        	cardCheck = CardDBConnect.cardCheck(nic);
	        	
	        	if(cardCheck == true) {
	        		List<Customer> cusDetails = CustomerDBConncet.getCustomerDetails(nic);
	    	        request.setAttribute("cusDetails", cusDetails);
	        		
		        	request.setAttribute("sendNumber", cardCheck);
		        	List<Card> cardDetails = CardDBConnect.getCardDetails(nic);
					request.setAttribute("cardDetails", cardDetails);
					
					accountBalance = CustomerDBConncet.getAccountBalance(nic);
					request.setAttribute("accountBalance", accountBalance);
					
					RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
		        	dis.forward(request, response);
	        	}
	        	else {
	        		List<Customer> cusDetails = CustomerDBConncet.getCustomerDetails(nic);
	    	        request.setAttribute("cusDetails", cusDetails);
	        		
	        		accountBalance = CustomerDBConncet.getAccountBalance(nic);
					request.setAttribute("accountBalance", accountBalance);
					
					request.setAttribute("sendNumber", cardCheck);
					
					RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
		        	dis.forward(request, response);
	        	}
	        } 
	        else {
	        	out.println("<script type='text/javascript'>");
				out.println("alert('Username or Password is incorrect');");
				out.println("location='customerlogin.jsp';");
				out.println("</script>");	
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
