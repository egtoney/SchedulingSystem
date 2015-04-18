package com.scheduler.code.employees;

import java.util.LinkedList;

public class Employee {
	
	//Employee fields
	private String name;
	private String DOB;
	private String SSN;
	private String address;
	private String phone_number;
	private String password;
	private String username;
	private double pay_rate;
	private double scheduled_hours;
	private double preferred_hours;
	private LinkedList<Double> availability = new LinkedList<>();
	private LinkedList<String> positions = new LinkedList<>();
	
	//Constructor
	public Employee(String name, String DOB, String SSN, String address, double pay_rate, LinkedList<Double> availability, LinkedList<String> positions, double preferred_hours, String phone_number, String password, String username) {
		this.name = name;
		this.DOB = DOB;
		this.SSN = SSN;
		this.address = address;
		this.pay_rate = pay_rate;
		this.availability = availability;
		this.positions = positions;
		this.preferred_hours = preferred_hours;
		this.phone_number = phone_number;
		this.password = password;
		this.username = username;
		scheduled_hours = 0;
	}
	
	//Set functions
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPayRate(double pay_rate) {
		this.pay_rate = pay_rate;
	}
	
	public void setAvailability(LinkedList<Double> availability) {
		this.availability = availability;
	}
	
	public void setPositions(LinkedList<String> positions) {
		this.positions = positions;
	}
	
	public void setScheduledHours(double scheduled_hours) {
		this.scheduled_hours += scheduled_hours;
	}
	
	public void setPreferredHours(double preferred_hours) {
		this.preferred_hours = preferred_hours;
	}
	
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	//Get functions
	public String getName() {
		return name;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getSSN() {
		return SSN;
	}
	
	public String getAddress() {
		return address;
	}
	
	public double getPayRate() {
		return pay_rate;
	}
	
	public LinkedList<Double> getAvailability() {
		return availability;
	}
	
	public LinkedList<String> getPositions() {
		return positions;
	}
	
	public double getScheduledHours() {
		return scheduled_hours;
	}
	
	public double getPreferredHours() {
		return preferred_hours;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getPassword(String password) {
		return password;
	}
	
	public String getUsername(String username) {
		return username;
	}
}
