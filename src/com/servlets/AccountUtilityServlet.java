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

import com.dbConnect.AccountUtilityDBConnect;
import com.dbConnect.CustomerDBConncet;
import com.javaClasses.Transaction;

@WebServlet("/AccountUtilityServlet")
public class AccountUtilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			double amount = AccountUtilityDBConnect.getTotalAccounts();
	    	request.setAttribute("amount", amount);
	    	
	    	int numOfTrans = AccountUtilityDBConnect.numberOfTransactions();
	    	request.setAttribute("numOfTrans", numOfTrans);
	    		
	    	int count = CustomerDBConncet.getTotalAccounts();
	    	request.setAttribute("count", count);
	    	
	    	List<Transaction> transList = AccountUtilityDBConnect.getTransactionDetails();
	    	request.setAttribute("transList", transList);
	    	
	    	RequestDispatcher dis = request.getRequestDispatcher("alltransactions.jsp");
	    	dis.forward(request, response);
		}
		catch (Exception e) {
			out.println(e);
		}
		
	}

}
