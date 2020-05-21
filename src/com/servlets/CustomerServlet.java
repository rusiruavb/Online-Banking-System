package com.servlets;

import com.dbConnect.*;
import com.javaClasses.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean cardCheck;
		boolean checkLoan;
		double accountBalance;
		
		HttpSession session=request.getSession();
		String nic = session.getAttribute("nic").toString();
		
		try {
			
			List<Customer> cusDetails = CustomerDBConncet.getCustomerDetails(nic);
			request.setAttribute("cusDetails", cusDetails);
			
			cardCheck = CardDBConnect.cardCheck(nic);
			checkLoan = CustomerDBConncet.checkLoan(nic);
			
			if(cardCheck == true) {
	        	request.setAttribute("sendNumber", cardCheck);
	        	List<Card> cardDetails = CardDBConnect.getCardDetails(nic);
				request.setAttribute("cardDetails", cardDetails);
				
				accountBalance = CustomerDBConncet.getAccountBalance(nic);
				request.setAttribute("accountBalance", accountBalance);
				
				if(checkLoan == true) {
					request.setAttribute("loanTrue", checkLoan);
					List<Loan> loanDetails = CustomerDBConncet.getCustomerLoanDetails(nic);
					request.setAttribute("loanDetails", loanDetails);
				}
				
				RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
	        	dis.forward(request, response);
        	}
        	else {
        		accountBalance = CustomerDBConncet.getAccountBalance(nic);
				request.setAttribute("accountBalance", accountBalance);
				
				request.setAttribute("sendNumber", cardCheck);
				
				if(checkLoan == true) {
					request.setAttribute("loanTrue", checkLoan);
					List<Loan> loanDetails = CustomerDBConncet.getCustomerLoanDetails(nic);
					request.setAttribute("loanDetails", loanDetails);
				}
				
				RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
	        	dis.forward(request, response);
        	}
				
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error in CustomerServlet");
		}
	}

}
