package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.AccountUtilityDBConnect;
import com.dbConnect.AdminDBConncet;
import com.dbConnect.CustomerDBConncet;
import com.dbConnect.EmployeeDBConnect;
import com.javaClasses.Employee;
import com.javaClasses.Loan;
import com.javaClasses.Message;

@WebServlet("/DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String accNumber = request.getParameter("id");
		boolean isSccess;
		
		isSccess = AdminDBConncet.deleteMessage(accNumber);
		
		if(isSccess == true) {
			double amount = AccountUtilityDBConnect.getTotalAccounts();
	    	request.setAttribute("amount", amount);
	    	
	    	int numOfTrans = AccountUtilityDBConnect.numberOfTransactions();
	    	request.setAttribute("numOfTrans", numOfTrans);
	    		
	    	int count = CustomerDBConncet.getTotalAccounts();
	    	request.setAttribute("count", count);
	    	
	    	List<Loan> loanDetails = AdminDBConncet.getLoanDetails();
	    	request.setAttribute("loanDetails", loanDetails);
	        
	        List<Message> allMessages = AdminDBConncet.getMessageDetails();
	    	request.setAttribute("allMessages", allMessages);

	        List<Employee> empDetails = EmployeeDBConnect.getEmployee();
	        request.setAttribute("empDetails", empDetails);
	        	
	        RequestDispatcher dis = request.getRequestDispatcher("adminhome.jsp");
	    	dis.forward(request, response);
		}
		else {
			//do nothing
		}
		
	}

}
