package com.dbConnect;

import com.dbConnect.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.javaClasses.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBConncet implements ICustomer{
	
	private static int count;
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
    public static List<Customer> getCustomer() {
	
	   	ArrayList<Customer> cus = new ArrayList<>();
	   	
	   	//validate  	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from customer LIMIT 0,5";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int accno = rs.getInt(1);
		   		String NIC = rs.getString(2);
		   		String name = rs.getString(3);
		   		String email = rs.getString(4);
		   		String address = rs.getString(5);
		   		String phone = rs.getString(6);
		   		String dob = rs.getString(7);
		   		String gender = rs.getString(8);
		   		String pwd = rs.getString(9);
		   		
		   		Customer c = new Customer(accno,NIC,name,email,address,phone,dob,gender,pwd);
		   		cus.add(c);
	   	    }
	   		con.close();
		   	stmt.close();   	    
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
	   
	   	return cus;
   	
    }
    
    public static int insertcustomer(String nic, String name, String address, String email, 
    		String phone, String dob, String gender, String password) {
    	
    	int value = 0;
    	
       	try {
           	con = DBConnect.getConnection();
           	stmt = con.createStatement();
        	String sql = "insert into customer(nic,name,email,address,phone,dob,gender,password) values('"+nic+"','"+name+"','"+email+"',"
        			+ "'"+address+"','"+phone+"','"+dob+"','"+gender+"','"+password+"')";	    
        	int rs = stmt.executeUpdate(sql);
        	if(rs == 1) {
       	    	value = 1;
       	    } 
       	    else {
       	    	//do nothing
       	    }
        	con.close();
    	   	stmt.close();
       	}
       	catch(Exception e) {
       	    e.printStackTrace();
       	}
       	return value;
    }
    
    public static int updatecustomer(String id, String nic, String name, String email, 
    		String address, String phone, String dob, String gender, String password) {
    	
    	int value = 0;

       	try {
           	con = DBConnect.getConnection();
           	stmt = con.createStatement();
        	String sql = "UPDATE customer SET accNo='"+id+"',nic='"+nic+"',name='"+name+"',email='"+email+"',address='"+address+"',phone='"+phone+"',"
        			+ "dob='"+dob+"',gender='"+gender+"',password='"+password+"' where accNo='"+id+"'";	    
        	int rs = stmt.executeUpdate(sql);
        	
        	if(rs == 1) {
       	    	value = 1;
       	    } 
       	    else {
       	    	//do nothing
       	    }
        	con.close();
    	   	stmt.close();
       	}
       	catch(Exception e) {
       	    e.printStackTrace();
       	}
       	return value;   	
    }
    
    public static boolean deletecustomer(String id) {
    	
    	try {
    		con = DBConnect.getConnection();
           	stmt = con.createStatement();
    		String sql = "delete from customer where accNo='"+id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if (rs > 0) {
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
    
    public static int getTotalAccounts() {

	   	//validate  	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select COUNT(NIC) from customer";	    
	   	    rs = stmt.executeQuery(sql);

	   	    if(rs.next()) {
	   	    	count = rs.getInt(1);
	   	    }
	   		con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
	   	
	   	return count;
	}
	
	public int getCount() {
		return count;
	}
    
	public static List<Customer> getCustomerDetails(String nic) {
		
	   	ArrayList<Customer> cus = new ArrayList<>();
	 
	   	//validate  	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from customer where nic='"+nic+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int accno = rs.getInt(1);
		   		String NIC = rs.getString(2);
		   		String name = rs.getString(3);
		   		String email = rs.getString(4);
		   		String address = rs.getString(5);
		   		String phone = rs.getString(6);
		   		String dob = rs.getString(7);
		   		String gender = rs.getString(8);
		   		String pwd = rs.getString(9);
		   		
		   		Customer c = new Customer(accno,NIC,name,email,address,phone,dob,gender,pwd);
		   		cus.add(c);
	   	    }
	   		con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	    System.out.println("error in getCustomerDetails(String nic)");
	   	}
	   	
	   	return cus;
   	
    }
	
	public static int getCustomerAccNo(String nic) {
		int accNo = 0;
		
		try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from customer where nic='"+nic+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int accno = rs.getInt(1);
	   	    	accNo=accno;
	   	    }
	   		con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	    System.out.println("error in getCustomerAccNo(String nic)");
	   	}
	   		
		return accNo;
	}
	
	public static void createAcc(int AccNo,String nic) {
		
		int accno = AccNo;
		String Nic = nic;
		int amount=0;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into account values('"+accno+"','"+nic+"','"+amount+"')";
			int rs = stmt.executeUpdate(sql);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static boolean validateCustomer(String nic, String password) {
		
	   	ArrayList<Customer> cus = new ArrayList<>();

	   	//validate  	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from customer where nic='"+nic+"' and password='"+password+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    if (rs.next()) {
	   	    	isSuccess = true;
	   	    }
	   	    else {
	   	    	isSuccess = false;
	   	    }
	   		con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
	   	
	   	return isSuccess;
   	
    }
	
	public static boolean transferMoney(int sendId, int recId, double amount) {
		
		boolean isTransfer = false;
	
	   	try {
	   		con = DBConnect.getConnection();
	   		stmt = con.createStatement();
	   	    String sql = "select * from account where accNo='"+sendId+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    //validate amount
			if(rs.next()) {
				double dbAmount = rs.getDouble(3);
				if(amount <= dbAmount) {
					//insert new recode to tansfer money table			
					String transferSql = "insert into transaction values (0,'"+sendId+"','"+recId+"','"+amount+"')";
					int rs2 = stmt.executeUpdate(transferSql);		
					isTransfer = true;
				} 
				else {
					isTransfer = false;
					System.out.println("Account balance not enough");
				}
			}
			else {	
				System.out.println("error in transfer method");
			}
			con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   		System.out.println(e);
	   	}
	
		return isTransfer;
	}
	
	public static void updateSenderMoney(int sendId, double amount) {
		
		double abstractAmount;
 	
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
	   	    String sql = "select * from account where accNo='"+sendId+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    if(rs.next()) {
		   	    double dbamount = rs.getDouble(3);
		   	    abstractAmount = dbamount - amount;
		   	    String senderSql = "UPDATE account SET amount='"+abstractAmount+"' where accNo='"+sendId+"'";
		   	    int execute1 = stmt.executeUpdate(senderSql);
	   	    }
	   		con.close();
		   	stmt.close();	   	    
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in update sender transfer method");
		}
	}
	
	public static void updateReceiverMoney(int recId, double amount) {
		
		double addAmount;
  	
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
	   	    String sql = "select * from account where accNo='"+recId+"'";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    if(rs.next()) {
		   	    double dbamount = rs.getDouble(3);
		   	    addAmount = dbamount + amount;
		   	    String senderSql = "UPDATE account SET amount='"+addAmount+"' where accNo='"+recId+"'";
		   	    int execute1 = stmt.executeUpdate(senderSql);
	   	    }
	   		con.close();
		   	stmt.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in update receiver transfer method");
		}
	}
	
	public static double getAccountBalance(String nic) {
		
		double accountBalance = 0;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from account where nic='"+nic+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				accountBalance = rs.getDouble(3);		
			}
			con.close();
		   	stmt.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error happened in getAccountBalance() method");
		}
		
		return accountBalance;
	}
	
	public static List<Customer> getAllCustomers() {
		
	   	ArrayList<Customer> cus = new ArrayList<>();
	
	   	try {
	   	    con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from customer";	    
	   	    rs = stmt.executeQuery(sql);
	   	    
	   	    while(rs.next()) {
	   	    	int accno = rs.getInt(1);
		   		String NIC = rs.getString(2);
		   		String name = rs.getString(3);
		   		String email = rs.getString(4);
		   		String address = rs.getString(5);
		   		String phone = rs.getString(6);
		   		String dob = rs.getString(7);
		   		String gender = rs.getString(8);
		   		String pwd = rs.getString(9);
		   		
		   		Customer c = new Customer(accno,NIC,name,email,address,phone,dob,gender,pwd);
		   		cus.add(c);
	   	    }
	   		con.close();
		   	stmt.close();
	   	}
	   	catch(Exception e) {
	   	    e.printStackTrace();
	   	}
	   	
	   	return cus;
   	
    }
	
	public static boolean sendMessage(String accNumber, String name, String email, String message) {
		
		int acNumber = Integer.parseInt(accNumber);
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO message VALUES(0,'"+acNumber+"','"+name+"','"+email+"','"+message+"',CURRENT_TIMESTAMP())";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
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
	
	public static boolean makePayment(String accNo, String firstName, String lastName, String email, String cardNumber, 
			String scode, String pcode, String amount) {
		
		int convAccNo = Integer.parseInt(accNo);
		double convAmount = Double.parseDouble(amount);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into payment values(0,'"+convAccNo+"','"+email+"','"+convAmount+"','"+cardNumber+"',"
					+ "'"+scode+"','"+pcode+"','"+firstName+"','"+lastName+"')";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
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
	
	public static void updatePayment(String accNo, String amount) {
		
		int convAccNo = Integer.parseInt(accNo);
		double convAmount = Double.parseDouble(amount);
		double updateedAmount=0;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from account where accNo='"+convAccNo+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				double dbamount = rs.getDouble(3);
				updateedAmount = dbamount - convAmount;
				String updateSQL = "UPDATE account SET amount='"+updateedAmount+"' where accNo='"+convAccNo+"'";
				stmt.executeUpdate(updateSQL);
			}
			else {
				System.out.println("no account number is here");
			}
			con.close();
		   	stmt.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean insertLoanDetails(String id, String name, String nic, String email, String phone,
			String salary, String loanamount, String description) {
		
		int convId = Integer.parseInt(id);
		double convSalary = Integer.parseInt(salary);
		double convLoan = Integer.parseInt(loanamount);
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into loan values (0,'"+convId+"','"+name+"','"+nic+"','"+email+"','"+phone+"',"
					+ "'"+convSalary+"','"+convLoan+"','"+description+"',0,CURDATE())";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
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
	
	public static List<Loan> getCustomerLoanDetails(String nic) {
		
		ArrayList<Loan> loan = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
	   	    stmt = con.createStatement();
	   	    String sql = "select * from loan where nic='"+nic+"'";
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
	
	public static boolean checkLoan(String nic) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from loan where nic='"+nic+"'";
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
