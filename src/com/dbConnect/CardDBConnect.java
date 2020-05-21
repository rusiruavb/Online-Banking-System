package com.dbConnect;

import com.javaClasses.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardDBConnect implements ICard {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	public static boolean insertCardDetails(String id, String name, String nic, String address, 
			String email, String phone, String occu, String salary, String cardType, String description) {
		
		int conId = Integer.parseInt(id);
		double conSalary = Double.parseDouble(salary);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into card values('"+conId+"','"+nic+"','"+name+"','"+address+"','"+email+"','"+phone+"',"
					+ "'"+occu+"','"+conSalary+"','"+cardType+"','"+description+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs == 1) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch (Exception e) {
			System.out.println("Somthing Happen.. error in 'insertCardDetails()' function");
		}
		
		return isSuccess;
	}
	
	public static boolean updateCardDetails(String accNo, String name, String nic, String address, 
			String email, String phone, String occu, String salary, String cardType) {
		
		int convAccNo = Integer.parseInt(accNo);
		double convSal = Double.parseDouble(salary);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE card SET accNo='"+convAccNo+"', nic='"+nic+"', name='"+name+"', address='"+address+"',"
					+ "email='"+email+"', phone='"+phone+"', occupation='"+occu+"', salary='"+convSal+"',type='"+cardType+"'"
							+ "where accNo='"+convAccNo+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean deleteCardDetails(String accNo) {
		
		int convAccNo = Integer.parseInt(accNo);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM card WHERE accNo='"+convAccNo+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Card> getCardDetails(String nic) {
		
		ArrayList<Card> card = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from card where nic='"+nic+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int accno = rs.getInt(1);
				String dbnic  = rs.getString(2);
				String name = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String occupation = rs.getString(7);
				double salary = rs.getDouble(8);
				String cardType = rs.getString(9);
				
				Card crd = new Card(accno,name,dbnic,address,email,phone,salary,occupation,cardType);
				card.add(crd);
			}
		}
		catch (Exception e) {
			//System.out.println("Somthing Happen.. error in 'getCardDetails()' function");
			e.printStackTrace();
		}
		
		return card;
	}
	
	public static boolean cardCheck(String nic) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from card where nic='"+nic+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
