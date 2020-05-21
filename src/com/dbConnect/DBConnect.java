package com.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	//give your database connection url
	private static String url = "jdbc:mysql://localhost:3306/online_banking";
	private static String userName = "root";
	//give your database password here
	private static String password = "";
	private static Connection con;

	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
	}
}
