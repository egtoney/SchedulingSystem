package com.scheduler.code.employees;

import java.util.LinkedList;

public class Manager extends Employee {
	
	//Manager fields
	private String manager_type;
	
	//Constructor
	public Manager(String name, String DOB, String SSN, String address, double pay_rate, LinkedList<String> availability, LinkedList<String> positions, String manager_type) {
		super(name, DOB, SSN, address, pay_rate, availability, positions):
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
