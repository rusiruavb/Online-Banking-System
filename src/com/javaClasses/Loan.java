package com.javaClasses;

public class Loan {

	private int loanId;
	private int userId;
	private String name;
	private String nic;
	private String email;
	private String phone;
	private double salary;
	private double loanamount;
	private String description;
	private int approve;
	private String time;
	
	public Loan(int loanId, int userId, String name, String nic, String email, String phone, double salary, double loanamount,
			String description, int approve, String time) {
		this.loanId = loanId;
		this.userId = userId;
		this.name = name;
		this.nic = nic;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.loanamount = loanamount;
		this.description = description;
		this.approve = approve;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public String getNic() {
		return nic;
	}

	public int getLoanId() {
		return loanId;
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
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

	public double getLoanamount() {
		return loanamount;
	}

	public String getDescription() {
		return description;
	}

	public int getApprove() {
		return approve;
	}

}
