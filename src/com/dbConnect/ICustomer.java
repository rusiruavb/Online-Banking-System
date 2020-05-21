package com.dbConnect;

import java.util.List;

import com.javaClasses.Customer;
import com.javaClasses.Loan;

public interface ICustomer {
	
	static List<Customer> getCustomer() {
		return null;
	}
	
	static int insertcustomer(String nic, String name, String address, String email, 
    		String phone, String dob, String gender, String password) {
		return 0;
	}
	
	static int updatecustomer(String id, String nic, String name, String email, 
    		String address, String phone, String dob, String gender, String password) {
		return 0;
	}
	
	static boolean deletecustomer(String id) {
		return false;
	}
	
	static int getTotalAccounts() {
		return 0;
	}
	
	static List<Customer> getCustomerDetails(String nic) {
		return null;
	}
	
	static List<Customer> validateCustomer(String nic, String password) {
		return null;
	}
	
	static boolean transferMoney(int sendId, int recId, double amount) {
		return false;
	}
	
	static void updateSenderMoney(int sendId, double amount) {}
	
	static void updateReceiverMoney(int recId, double amount) {};
	
	static double getAccountBalance(String nic) {
		return 0;
	}
	
	static List<Customer> getAllCustomers() {
		return null;
	}
	
	static boolean sendMessage(String accNumber, String name, String email, String message) {
		return false;
	}
	
	static boolean makePayment(String accNo, String firstName, String lastName, String email, String cardNumber, 
			String scode, String pcode, String amount) {
		return false;
	}
	
	static void updatePayment(String accNo, String amount) {}
	
	static boolean insertLoanDetails(String id, String name, String nic, String email, String phone,
			String salary, String loanamount, String description) {
		return false;
	}
	
	static List<Loan> getCustomerLoanDetails(String nic) {
		return null;
	}
	
	static boolean checkLoan(String nic) {
		return false;
	}
	 
}
