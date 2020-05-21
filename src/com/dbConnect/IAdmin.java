package com.dbConnect;

import java.util.List;

import com.javaClasses.Loan;
import com.javaClasses.Message;

public interface IAdmin {

	static boolean validate(String userName, String password) {
		return false;
	}
	
	static List<Message> getMessageDetails() {
		return null;
	}
	
	static boolean deleteMessage(String messageId) {
		return false;
	}
	
	static List<Loan> getLoanDetails() {
		return null;
	}
	
	static void loanApprove(String value, String loanID) {}
}
