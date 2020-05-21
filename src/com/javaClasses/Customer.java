package com.javaClasses;

public class Customer extends Person {
	
	private int accNumber;
    private String dob;
    private String gender;
    private String password;
    
	public Customer(int accNumber, String nic, String name, String email, String address, String phone, String dob, String gender, String password) {
		this.accNumber = accNumber;
		super.nic = nic;
		super.name = name;
		super.email = email;
		super.address = address;
		super.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

}
