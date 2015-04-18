package com.scheduler.code.scheduler;

public class TimeSlot {
	
	//TimeSlot fields
	private double begin;
	private double end;
	private String position;
	
	//Constructor
	public TimeSlot(double begin, double end, String position) {
		this.begin = begin;
		this.end = end;
		this.position = position;
	}
	
	//Set functions
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
