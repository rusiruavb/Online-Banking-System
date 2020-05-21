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
import javax.servlet.http.HttpSession;

@WebServlet("/MoneyTransferServlet")
public class MoneyTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String senderID = request.getParameter("sendid");
		String receiverID = request.getParameter("recid");
		String amount = request.getParameter("amount");

		
		int convSenderId = Integer.parseInt(senderID);
		int convReceiverId = Integer.parseInt(receiverID);
		double convAmount = Double.parseDouble(amount);

		try {
			
			boolean isSuccess = CustomerDBConncet.transferMoney(convSenderId, convReceiverId, convAmount);
			
			if(isSuccess == true) {
				
				CustomerDBConncet.updateSenderMoney(convSenderId, convAmount);
				CustomerDBConncet.updateReceiverMoney(convReceiverId, convAmount);

				response.sendRedirect("customerdetails");
				
			}
			else {	   		
				response.sendRedirect("customerdetails");
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
