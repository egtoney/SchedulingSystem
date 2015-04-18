package com.scheduler.code.scheduler;

import java.util.LinkedList;

public class Schedule {
	
	private LinkedList<EmployeeTimeSlot> monday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> tuesday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> wednesday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> thursday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> friday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> saturday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> sunday = new LinkedList<>();
	
	//Set functions
		public void setMonday(LinkedList<EmployeeTimeSlot> monday) {
			this.monday = monday;
		}
		
		public void setTuesday(LinkedList<EmployeeTimeSlot> tuesday) {
			this.tuesday = tuesday;
		}
		
		public void setWednesday(LinkedList<EmployeeTimeSlot> wednesday) {
			this.wednesday = wednesday;
		}
		
		public void setThursday(LinkedList<EmployeeTimeSlot> thursday) {
			this.thursday = thursday;
		}
		
		public void setFriday(LinkedList<EmployeeTimeSlot> friday) {
			this.friday = friday;
		}
		
		public void setSaturday(LinkedList<EmployeeTimeSlot> saturday) {
			this.saturday = saturday;
		}
		
		public void setSunday(LinkedList<EmployeeTimeSlot> sunday) {
			this.sunday = sunday;
		}
		
		//Get functions
		public LinkedList<EmployeeTimeSlot> getMonday() {
			return monday;
		}
		
		public LinkedList<EmployeeTimeSlot> getTuesday() {
			return tuesday;
		}
		
		public LinkedList<EmployeeTimeSlot> getWednesday() {
			return wednesday;
		}
		
		public LinkedList<EmployeeTimeSlot> getThursday() {
			return thursday;
		}
		
		public LinkedList<EmployeeTimeSlot> getFriday() {
			return friday;
		}
		
		public LinkedList<EmployeeTimeSlot> getSaturday() {
			return saturday;
		}
		
		public LinkedList<EmployeeTimeSlot> getSunday() {
			return sunday;
		}

}
