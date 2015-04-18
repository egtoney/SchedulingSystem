package com.scheduler.code.employees;

import java.util.LinkedList;

public class Employee {
	
	//Employee fields
	private String name;
	private String DOB;
	private String SSN;
	private String address;
	private double pay_rate;
	private double scheduled_hours;
	private LinkedList<String> ask_off_days = new LinkedList<>();
	private LinkedList<String> availability = new LinkedList<>();
	private LinkedList<String> positions = new LinkedList<>();
	
	//Constructor
	public Employee(String name, String DOB, String SSN, String address, double pay_rate, LinkedList<String> availability, LinkedList<String> positions, LinkedList<String> ask_off_days) {
		this.name = name;
		this.DOB = DOB;
		this.SSN = SSN;
		this.address = address;
		this.pay_rate = pay_rate;
		this.availability = availability;
		this.positions = positions;
		this.ask_off_days = ask_off_days;
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
	
	public void setAvailability(LinkedList<String> availability) {
		this.availability = availability;
	}
	
	public void setPositions(LinkedList<String> positions) {
		this.positions = positions;
	}
	
	public void setAskOffDays(LinkedList<String> ask_off_days) {
		this.ask_off_days = ask_off_days;
	}
	
	public void setScheduledHours(double scheduled_hours) {
		this.scheduled_hours = scheduled_hours;
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
	
	public LinkedList<String> getAvailability() {
		return availability;
	}
	
	public LinkedList<String> getPositions() {
		return positions;
	}
	
	public LinkedList<String> getAskOffDays() {
		return ask_off_days;
	}
	
	public double getScheduledHours() {
		return scheduled_hours;
	}
	

}
