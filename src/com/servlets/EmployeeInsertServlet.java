package com.servlets;

import com.dbConnect.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("empname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("empemail");
		String address = request.getParameter("empaddress");
		String phone = request.getParameter("empphone");
		String department = request.getParameter("empdep");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		boolean isInsertSuccess = EmployeeDBConnect.insertemployee(name, nic, email, address, phone, department);
		
		if(isInsertSuccess == true) {
			try {  		    	
				RequestDispatcher req = request.getRequestDispatcher("/admin");
				req.forward(request, response);
		    }
		    catch (Exception e) {
		    	out.println(e);
		    }
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Somthing Happened!!! Your NIC is already in the system');");
			out.println("location='insertemployee.jsp';");
			out.println("</script>");
		}
	}

}
