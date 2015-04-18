package com.scheduler.code.employees;

import java.util.LinkedList;

public class Manager extends Employee {
	
	//Manager fields
	private String manager_type;
	
	//Constructor
	public Manager(String name, String DOB, String SSN, String address, double pay_rate, LinkedList<Double> availability, LinkedList<String> positions, String manager_type, double preferred_hours, String phone_number, String password, String username) {
		super(name, DOB, SSN, address, pay_rate, availability, positions, preferred_hours, phone_number, password, username);
			this.manager_type = manager_type;
	}
	
	//Set function
	public void setManagerType(String manager_type) {
		this.manager_type = manager_type;
	}
	
	//Get function
	public String getManagerType() {
		return manager_type;
	}

}
