package com.scheduler.code.scheduler;

import java.util.LinkedList;

import com.scheduler.code.employees.Employee;

public class RawSchedule {
	
	private LinkedList<TimeSlot> monday = new LinkedList<>();
	private LinkedList<TimeSlot> tuesday = new LinkedList<>();
	private LinkedList<TimeSlot> wednesday = new LinkedList<>();
	private LinkedList<TimeSlot> thursday = new LinkedList<>();
	private LinkedList<TimeSlot> friday = new LinkedList<>();
	private LinkedList<TimeSlot> saturday = new LinkedList<>();
	private LinkedList<TimeSlot> sunday = new LinkedList<>();
	
	public RawSchedule(LinkedList<TimeSlot> monday, LinkedList<TimeSlot> tuesday, LinkedList<TimeSlot> wednesday, LinkedList<TimeSlot> thursday, LinkedList<TimeSlot> friday, LinkedList<TimeSlot> saturday, LinkedList<TimeSlot> sunday) {
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}
	
	//Set functions
	public void setMonday(LinkedList<TimeSlot> monday) {
		this.monday = monday;
	}
	
	public void setTuesday(LinkedList<TimeSlot> tuesday) {
		this.tuesday = tuesday;
	}
	
	public void setWednesday(LinkedList<TimeSlot> wednesday) {
		this.wednesday = wednesday;
	}
	
	public void setThursday(LinkedList<TimeSlot> thursday) {
		this.thursday = thursday;
	}
	
	public void setFriday(LinkedList<TimeSlot> friday) {
		this.friday = friday;
	}
	
	public void setSaturday(LinkedList<TimeSlot> saturday) {
		this.saturday = saturday;
	}
	
	public void setSunday(LinkedList<TimeSlot> sunday) {
		this.sunday = sunday;
	}
	
	//Get functions
	public LinkedList<TimeSlot> getMonday() {
		return monday;
	}
	
	public LinkedList<TimeSlot> getTuesday() {
		return tuesday;
	}
	
	public LinkedList<TimeSlot> getWednesday() {
		return wednesday;
	}
	
	public LinkedList<TimeSlot> getThursday() {
		return thursday;
	}
	
	public LinkedList<TimeSlot> getFriday() {
		return friday;
	}
	
	public LinkedList<TimeSlot> getSaturday() {
		return saturday;
	}
	
	public LinkedList<TimeSlot> getSunday() {
		return sunday;
	}
	
	//********Random Schedule Generator********\\
	public LinkedList<EmployeeTimeSlot> generateSchedule(LinkedList<TimeSlot> day) {
		LinkedList<EmployeeTimeSlot> generated_schedule = new LinkedList<>();
		
		
		
		return generated_schedule;
	}
	
	
	
	

}
