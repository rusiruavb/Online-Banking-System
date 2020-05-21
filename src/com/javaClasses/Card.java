package com.javaClasses;

public class Card {
	
	private int accountNumber;
	private String name;
	private String nic;
	private String address;
	private String email;
	private String phone;
	private double salary;
	private String occupation;
	private String cardType;
	
	public Card(int accountNumber, String name, String nic, String address, String email, String phone, double salary,
			String occupation, String cartType) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.nic = nic;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.occupation = occupation;
		this.cardType = cartType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public String getNic() {
		return nic;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public double getSalary() {
		return salary;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getCardType() {
		return cardType;
	}

}
