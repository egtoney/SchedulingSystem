package com.scheduler.code.networking;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import com.scheduler.code.employees.Employee;

public class DataPackage {
	
	private LinkedList<Employee> employee_list = new LinkedList<>();
	
	public DataPackage(String result) {
		LinkedList<Employee> employee_list = new LinkedList<>();
		String[] employees = result.split(";");
		
		for(int i = 0; i < employees.length; i++) {
			String[] field_array = employees[i].split(":");
			
			String name = field_array[0];
			double preferred_hours = Double.parseDouble(field_array[1]);
			double pay_rate = Double.parseDouble(field_array[2]);
			String DOB = field_array[3];
			String SSN = field_array[4];
			String address = field_array[5]+"_"+field_array[6]+"_"+field_array[7]+"_"+field_array[8];
			
			LinkedList<String> positions = new LinkedList<>();
			for(String s : field_array[9].split(",")) {
				positions.add(s);
			}
			
			LinkedList<Double> availability = parseAvailability(field_array[10]);
			
			Boolean[] ask_offs = parseAskOffDays(field_array[11]);
			for(int j = 0; j < ask_offs.length; j++) {
				if(ask_offs[j]) {
					availability.set(j*2, 0.0); 
					availability.set(j*2+1, 0.0);
				}
			}
			
			String phone_number = field_array[12];
			String username = field_array[13];
			
			Employee new_employee = new Employee(name, DOB, SSN, address, pay_rate, availability, positions, preferred_hours, phone_number, username, "");
			employee_list.add(new_employee);
		}
		this.employee_list = employee_list;
	}
	
	public LinkedList<Double> parseAvailability(String s_availability) {
		LinkedList<Double> i_availability = new LinkedList<>();
		
		String[] days = s_availability.split(",");
		int days_size = days.length*2;
		String[] days_hours = new String[days_size];
		int i = 0;
		
		for(String s : days) {
			String[] temp = s.split("-");
			days_hours[i] = temp[0];
			days_hours[i+1] = temp[1];
			i += 2;
		}
		
		for(String s : days_hours) {
			String[] temp = s.split("_");
			double hours = Double.parseDouble(temp[0]); double minutes = Double.parseDouble(temp[1]);
			if(minutes == 30)
				i_availability.add(hours+.5);
			else
				i_availability.add(hours);
		}
		
		
		return i_availability;
	}
	
	public Boolean[] parseAskOffDays(String aod) {
		Boolean[] a_o_d = {false, false, false, false, false, false, false};
		
		Calendar c = new GregorianCalendar();
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		
		if(weekday != Calendar.MONDAY) {
			while(weekday != Calendar.MONDAY) {
				c.add(Calendar.DAY_OF_YEAR, 1);
				weekday = c.get(Calendar.DAY_OF_WEEK);
			}
		}
		else {
			c.add(Calendar.DAY_OF_YEAR, 7);
		}
		
		int this_monday = c.get(Calendar.DAY_OF_YEAR);
		int sunday = this_monday+6;
		System.out.println(this_monday);
		System.out.println(sunday);
        
		for(String s : aod.split(",")) {
			int day_of_year = getDayOfYear(s);
			
			System.out.println(day_of_year);
			if(day_of_year >= this_monday && day_of_year <= sunday) {
				System.out.println(day_of_year-this_monday);
				a_o_d[day_of_year-this_monday] = true;
			}
			
		}
		
		return a_o_d;
	}
	
	public int getDayOfYear(String dateString) {
			String[] date = dateString.split("_");
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(date[2]), Integer.parseInt(date[0])-1, Integer.parseInt(date[1]));
			return c.get(Calendar.DAY_OF_YEAR);
		}
	
	public LinkedList<Employee> getEmployeeList() {
		return employee_list;
	}

}
