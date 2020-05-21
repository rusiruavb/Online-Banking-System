package com.dbConnect;

import java.util.List;

import com.javaClasses.Employee;

public interface IEmployee {

	static List<Employee> getEmployee() {
		return null;
	}
	
	static boolean insertemployee(String empid, String name, String nic, String email, String address, String phone, String dep) {
		return false;
	}
	
	static int updateEmployee(String empid, String name, String nic, String email, String address, String phone, String dep) {
		return 0;
	}
	
	static int deleteEmployee(String id) {
		return 0;
	}
}
