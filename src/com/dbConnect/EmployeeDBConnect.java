package com.dbConnect;

import java.sql.Connection;
import com.javaClasses.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBConnect implements IEmployee {
	
	static boolean isinsertsuccess;
    
    public static List<Employee> getEmployee() {
	
       	ArrayList<Employee> emp = new ArrayList<>();
       	
       	//create database connection
       	String url = "jdbc:mysql://localhost:3306/online_banking";
       	String user = "root";
       	String pass = "RavB1998";
       	
       	//validate
       	
       	try {
       	    
       	    Class.forName("com.mysql.jdbc.Driver");
       	    
       	    Connection con = DriverManager.getConnection(url, user, pass);
       	    Statement stmt = con.createStatement();
       	    String sql = "select * from employee";	    
       	    ResultSet rs = stmt.executeQuery(sql);
       	    
       	    while(rs.next()) {
       		String id = rs.getString(1);
       		String name = rs.getString(2);
       		String nic = rs.getString(3);
       		String email = rs.getString(4); 		
       		String address = rs.getString(5);
       		String phone = rs.getString(6);
       		String department = rs.getString(7);
       		
       		Employee e = new Employee(id,name,nic,email,address,phone,department);
       		emp.add(e);
       	    }
       	    
       	}
       	catch(Exception e) {
       	    e.printStackTrace();
       	}
       	
       	return emp;
   	
    }
    
    public static boolean insertemployee(String name, String nic, String email, String address, String phone, String dep) {
		
		//create database connection
	   	String url = "jdbc:mysql://localhost:3306/online_banking";
	   	String user = "root";
	   	String pass = "RavB1998";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
    	    
	    	Connection con = DriverManager.getConnection(url, user, pass);
	    	Statement stmt = con.createStatement();
	    	String sql = "insert into employee values (0,'"+name+"','"+nic+"','"+email+"','"+address+"','"+phone+"','"+dep+"')";	    
	    	int rs = stmt.executeUpdate(sql);
	    	
	    	if (rs > 0) {
	    		isinsertsuccess = true;
	    	} else {
	    		isinsertsuccess = false;
	    	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		return isinsertsuccess;
	}
    
    public static int updateEmployee(String empid, String name, String nic, String email, String address, String phone, String dep) {
    	
    	int value =0;
    	
    	//create database connection
       	String url = "jdbc:mysql://localhost:3306/online_banking";
       	String user = "root";
       	String pass = "RavB1998";
       	
       	try {
       		Class.forName("com.mysql.jdbc.Driver");
       	    
       	    Connection con = DriverManager.getConnection(url, user, pass);
       	    Statement stmt = con.createStatement();
       	    String sql = "UPDATE employee SET empid='"+empid+"',name='"+name+"',nic='"+nic+"',email='"+email+"',address='"+address+"',phone='"+phone+"',department='"+dep+"' where empid='"+empid+"'";	    
       	    int rs = stmt.executeUpdate(sql);
       	    
       	    if(rs == 1) {
       	    	value = 1;
       	    } 
       	    else {
       	    	//do nothing
       	    }
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       	return value;
    }
    
    public static int deleteEmployee(String id) {
    	
    	int deleteValue = 0;
    	
    	String url = "jdbc:mysql://localhost:3306/online_banking";
       	String user = "root";
       	String pass = "RavB1998";
       	
       	try {
       		Class.forName("com.mysql.jdbc.Driver");
       	    
       	    Connection con = DriverManager.getConnection(url, user, pass);
       	    Statement stmt = con.createStatement();
       	    String sql = "DELETE FROM employee WHERE empid='"+id+"'";	    
       	    int rs = stmt.executeUpdate(sql);
       	    
       	    if(rs == 1) {
       	    	deleteValue = 1;
       	    } 
       	    else {
       	    	//do nothing
       	    }
       	}
       	catch(Exception e) {
       		e.printStackTrace();
       	}
       	return deleteValue;
    }
}
