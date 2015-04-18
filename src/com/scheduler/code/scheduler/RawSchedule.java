package com.scheduler.code.scheduler;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import com.scheduler.code.employees.Employee;

public class RawSchedule {
	
	/*----------------DEBUG-------------*\
	public static void main(String[] arg) {
		LinkedList<Double> availability = new LinkedList<>();
		LinkedList<String> positions = new LinkedList<>();
		LinkedList<String> positions1 = new LinkedList<>();
		LinkedList<String> positions2 = new LinkedList<>();
		for(int i = 0; i < 7; i++)
		{
			availability.add(0.0);
			availability.add(24.0);
		}
		
		positions.add("G");
		positions.add("W");
		positions.add("C");
		
		positions1.add("G");
		positions1.add("W");
		
		positions2.add("C");
		
		Employee employee1 = new Employee("A", "blank", "blank", "blank", 99.99, availability, positions, 40);
		Employee employee2 = new Employee("B", "blank", "blank", "blank", 99.99, availability, positions1, 40);
		Employee employee3 = new Employee("C", "blank", "blank", "blank", 99.99, availability, positions2, 40);
		Employee employee4 = new Employee("D", "blank", "blank", "blank", 99.99, availability, positions2, 40);
		Employee employee5 = new Employee("E", "blank", "blank", "blank", 99.99, availability, positions1, 40);
		Employee employee6 = new Employee("F", "blank", "blank", "blank", 99.99, availability, positions1, 40);
		Employee employee7 = new Employee("G", "blank", "blank", "blank", 99.99, availability, positions, 40);
		Employee employee8 = new Employee("H", "blank", "blank", "blank", 99.99, availability, positions, 40);
		Employee employee9 = new Employee("I", "blank", "blank", "blank", 99.99, availability, positions2, 40);
		Employee employee10 = new Employee("J", "blank", "blank", "blank", 99.99, availability, positions, 40);
		Employee employee11 = new Employee("K", "blank", "blank", "blank", 99.99, availability, positions1, 40);
		Employee employee12 = new Employee("L", "blank", "blank", "blank", 99.99, availability, positions, 40);
		LinkedList<Employee> employee = new LinkedList<>();
		employee.add(employee1); employee.add(employee2); employee.add(employee3); employee.add(employee4); employee.add(employee5); employee.add(employee6); employee.add(employee7); employee.add(employee8); employee.add(employee9); employee.add(employee10); employee.add(employee11); employee.add(employee12);
	
		TimeSlot slot1 = new TimeSlot(4.0, 14.0, "C");
		TimeSlot slot2 = new TimeSlot(4.0, 14.0, "W");
		TimeSlot slot3 = new TimeSlot(4.0, 14.0, "G");
		TimeSlot slot4 = new TimeSlot(8.0, 16.0, "G");
		TimeSlot slot5 = new TimeSlot(8.0, 16.0, "W");
		TimeSlot slot6 = new TimeSlot(8.0, 16.0, "C");
		LinkedList<TimeSlot> m = new LinkedList<>();
		m.add(slot1); m.add(slot2); m.add(slot3); m.add(slot4); m.add(slot5); m.add(slot6);
		
		LinkedList<EmployeeTimeSlot> schedule = generateSchedule("monday", positions, m, employee);
		for(EmployeeTimeSlot ets : schedule) {
			System.out.println(ets.getName());
			System.out.println(ets.getBegin());
			System.out.println(ets.getEnd());
			System.out.println(ets.getPosition());
		}
	}
	*/
	
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
	public static LinkedList<EmployeeTimeSlot> generateSchedule(String s_day, LinkedList<String> positions, LinkedList<TimeSlot> day, LinkedList<Employee> employee_list) {
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
					if(begin >= availability.get(i_day) && availability.get(i_day+1) >= end) {
						EmployeeTimeSlot ets = new EmployeeTimeSlot(e.getName(), begin, end, pos);
						generated_schedule.add(ets);
						found = true;
						Set<String> keys = position_list.keySet();
				        for(String k: keys){
				        	position_list.get(k).remove(e);
				        }
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
	
	public static int dayToInt(String day) {
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
