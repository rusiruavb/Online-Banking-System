package com.javaClasses;

public class Employee extends Person{
    
    private String empid;
    private String department;
    
	public Employee(String empid, String name, String nIC, String email, String address, String phone, String department) {
		this.empid = empid;
		super.name = name;
		super.nic = nIC;
		super.email = email;
		super.address = address;
		super.phone = phone;
		this.department = department;
	}

	public String getEmpid() {
		return empid;
	}

	public String getDepartment() {
		return department;
	}

}
