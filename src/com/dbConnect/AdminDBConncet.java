package com.dbConnect;

import com.javaClasses.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDBConncet implements IAdmin {
	
	static boolean status;
	static int rsapprove;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static boolean validate(String userName, String password) {
		
		
		
	   	try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	    	String sql = "select * from admin where adminid='"+userName+"' and password='"+password+"'";	    
	    	rs = stmt.executeQuery(sql);
	    	
	    	if(rs.next()) {
	    		status = true;
	    	} else {
	    		status = false;
	    	}
	    	con.close();
	    	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
		
	   	return status;
	}
	
	public static List<Message> getMessageDetails() {
		
		ArrayList<Message> msg = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from message order by time desc LIMIT 0,7";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int mid = rs.getInt(1);
				int accId = rs.getInt(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				String mess = rs.getString(5);
				String time = rs.getString(6);
				
				Message message = new Message(mid,accId,name,email,mess,time);
				msg.add(message);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public static boolean deleteMessage(String messageId) {
		
		int convAccNo = Integer.parseInt(messageId);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM message WHERE mid='"+convAccNo+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				status = true;
			}
			else {
				status = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Loan> getLoanDetails() {
		
		ArrayList<Loan> loan = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from loan where approve='"+0+"' order by sendtime desc LIMIT 0,5";
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int loanId = rs.getInt(1);
	   	    	int userId = rs.getInt(2);
	   	    	String name = rs.getString(3);
	   	    	String dbnic = rs.getString(4);
	   	    	String email = rs.getString(5);
	   	    	String phone = rs.getString(6);
	   	    	double salary = rs.getDouble(7);
	   	    	double loanAmount = rs.getDouble(8);
	   	    	String description = rs.getString(9);
	   	    	int approve = rs.getInt(10);
	   	    	String time = rs.getString(11);
	   	    	
	   	    	Loan ln = new Loan(loanId,userId,name,dbnic,email,phone,salary,
	   	    			loanAmount,description,approve,time);
	   	    	loan.add(ln);
	   	    	
	   	    }
	   	    con.close();
		   	stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return loan;
	}
	
public static List<Loan> getAllLoanDetails() {
		
		ArrayList<Loan> loan = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from loan where approve='"+1+"' order by sendtime desc";
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int loanId = rs.getInt(1);
	   	    	int userId = rs.getInt(2);
	   	    	String name = rs.getString(3);
	   	    	String dbnic = rs.getString(4);
	   	    	String email = rs.getString(5);
	   	    	String phone = rs.getString(6);
	   	    	double salary = rs.getDouble(7);
	   	    	double loanAmount = rs.getDouble(8);
	   	    	String description = rs.getString(9);
	   	    	int approve = rs.getInt(10);
	   	    	String time = rs.getString(11);
	   	    	
	   	    	Loan ln = new Loan(loanId,userId,name,dbnic,email,phone,salary,
	   	    			loanAmount,description,approve,time);
	   	    	loan.add(ln);
	   	    	
	   	    }
	   	    con.close();
		   	stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return loan;
	}
	
	public static void loanApprove(String value, String loanID) {
		
		int dbValue = 0;
		String approve = "approve";
		int loanId = Integer.parseInt(loanID);
	
		try {
			
			if (value.equals(approve)) {
				dbValue = 1;
			} 
			
			con = DBConnect.getConnection();
		   	stmt = con.createStatement();
		   	String sql = "UPDATE loan SET approve='"+dbValue+"' where loanID='"+loanId+"'";
		   	rsapprove = stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(value);
		}
			

	}
}
