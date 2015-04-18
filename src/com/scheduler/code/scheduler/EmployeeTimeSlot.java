package com.scheduler.code.scheduler;

public class EmployeeTimeSlot {

	//EmployeeTimeSlot fields
	private String name;
	private double begin;
	private double end;
	private String position;
	
	//Constructor
	public EmployeeTimeSlot(String name, double begin, double end, String position) {
		this.name = name;
		this.begin = begin;
		this.end = end;
		this.position = position;
	}
	
	//Set functions
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBegin(double begin) {
		this.begin = begin;
	}
	
	public void setEnd(double end) {
		this.end = end;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	//Get functions
	public String getName() {
		return name;
	}
	
	public double getBegin() {
		return begin;
	}
	
	public double getEnd() {
		return end;
	}
	
	public String getPosition() { 
		return position;
	}
	
}
