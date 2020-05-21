package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbConnect.AdminDBConncet;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("aid");
		String password = request.getParameter("pass");
		
		boolean status = AdminDBConncet.validate(userName, password);
		
		if(status == true) {
			HttpSession session=request.getSession();  
        	session.setAttribute("aid", userName);
			
			RequestDispatcher dis = request.getRequestDispatcher("/admin");
	    	dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("adminlogin.jsp");
	    	dis.forward(request, response);
		}
	}

}
