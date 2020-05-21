package com.dbConnect;

import com.javaClasses.*;
import com.dbConnect.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountUtilityDBConnect {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static double totAmount;
	private static int numOfTransaction;
	
	public static double getTotalAccounts() {	   	
	   	//validate  	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select SUM(amount) from account";	    
	   	    rs = stmt.executeQuery(sql);

	   	    if(rs.next()) {
	   	    	String amount = rs.getString("sum(amount)");
	   	    	totAmount = Double.parseDouble(amount);
	   	    }
	   	    
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
	   	
	   	return totAmount;
	}
	
	public double getTotAmount() {
   		return totAmount;
   	}
	
	public static int numberOfTransactions() {
		
		try {
			con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select COUNT(tid) from transaction";
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    if(rs.next()) {
	   	    	String numOfTrans = rs.getString("count(tid)");
	   	    	numOfTransaction  = Integer.parseInt(numOfTrans);
	   	    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return numOfTransaction;
	}

	public static List<Transaction> getTransactionDetails() {
		
		ArrayList<Transaction> trans = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from transaction  order by tid desc LIMIT 0,10";
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int tId = rs.getInt(1);
	   	    	int sendId = rs.getInt(2);
	   	    	int receId = rs.getInt(3);
	   	    	double amount = rs.getInt(4);
	   	    	
	   	    	Transaction transaction = new Transaction(tId, sendId, receId, amount);
	   	    	trans.add(transaction);
	   	    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return trans;
	}
}

