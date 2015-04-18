package com.scheduler.code.scheduler;

import java.util.Hashtable;
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
	public LinkedList<EmployeeTimeSlot> generateSchedule(String s_day, LinkedList<String> positions, LinkedList<TimeSlot> day, LinkedList<Employee> employee_list) {
		LinkedList<EmployeeTimeSlot> generated_schedule = new LinkedList<>();
		Hashtable< String, LinkedList<Employee> > position_list = new Hashtable<>();
		int i_day = dayToInt(s_day);
		
		if(i_day == -1)
			return generated_schedule;
		
		for(String p : positions) {
			LinkedList<Employee> new_list = new LinkedList<>();
			position_list.put(p, new_list);
		}
		
		for(Employee e : employee_list) {
			for(String p : e.getPositions()) {
				position_list.get(p).add(e);
			}
		}
		
		for(TimeSlot t : day) { 
			double begin = t.getBegin();
			double end = t.getEnd();
			String pos = t.getPosition();
			boolean found = false;
			for(Employee e : position_list.get(pos)) {
				LinkedList<Double> availability = e.getAvailability();
				if(((availability.get(i_day+1) - availability.get(i_day)) != 0) && ((end - begin + e.getScheduledHours()) <= e.getPreferredHours())) {
					if(availability.get(i_day) >= begin && availability.get(i_day+1) <= end) {
						EmployeeTimeSlot ets = new EmployeeTimeSlot(e.getName(), begin, end, pos);
						generated_schedule.add(ets);
						found = true;
						break;
					}
				}
			}
			if(!found)
			{
				EmployeeTimeSlot ets = new EmployeeTimeSlot("No employee match", begin, end, pos);
				generated_schedule.add(ets);
			}
		}
		return generated_schedule;
	}
	
	public int dayToInt(String day) {
		if(day == "monday") return 0;
		if(day == "tuesday") return 2;
		if(day == "wednesday") return 4;
		if(day == "thursday") return 6;
		if(day == "friday") return 8;
		if(day == "saturday") return 10;
		if(day == "sunday") return 12;
		return -1;
	}
	
	
	

}
