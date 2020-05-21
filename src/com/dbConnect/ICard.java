package com.dbConnect;

import java.util.List;

import com.javaClasses.Card;

public interface ICard {

	static boolean insertCardDetails(String id, String name, String nic, String address, 
			String email, String phone, String occu, String salary, String cardType, String description) {
		return false;
	}
	
	static boolean updateCardDetails(String accNo, String name, String nic, String address, 
			String email, String phone, String occu, String salary, String cardType) {
		return false;
	}
	
	static boolean deleteCardDetails(String accNo) {
		return false;
	}
	
	static List<Card> getCardDetails(String nic) {
		return null;
	}
	
	static boolean cardCheck(String nic) {
		return false;
	}
}
