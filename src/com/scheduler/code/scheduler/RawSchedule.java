package com.scheduler.code.scheduler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.scheduler.code.employees.Employee;
import com.scheduler.code.networking.DataPackage;

public class RawSchedule extends JTabbedPane{
	
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 315191538193202318L;
	private LinkedList<EmployeeTimeSlot> monday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> tuesday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> wednesday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> thursday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> friday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> saturday = new LinkedList<>();
	private LinkedList<EmployeeTimeSlot> sunday = new LinkedList<>();
	
	// constructor for predefined time slots
	public RawSchedule(LinkedList<EmployeeTimeSlot> monday, LinkedList<EmployeeTimeSlot> tuesday, LinkedList<EmployeeTimeSlot> wednesday, LinkedList<EmployeeTimeSlot> thursday, LinkedList<EmployeeTimeSlot> friday, LinkedList<EmployeeTimeSlot> saturday, LinkedList<EmployeeTimeSlot> sunday) {
		super();
		
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		
		initGUI();
	}
	
	// constructor for new time slots
	public RawSchedule(DataPackage data) {
		super();

		monday.add(new EmployeeTimeSlot("Ethan Toney",1.5,5.5,"Cook"));
		monday.add(new EmployeeTimeSlot("Ethan Toney",5.5,7.0,"Cook 2.0"));
		
		initGUI();
	}
	
	public void addTimeSlot(double lower, double higher, String position){
		getDaysTimeSlots(this.getSelectedIndex()+1).add(new EmployeeTimeSlot("",lower,higher,position));
	}
	
	private void initGUI(){
		String tab_names[] = {"Sun","Mon","Tues","Wed","Thurs","Fri","Sat"};
		for(int i=1 ; i<07 ; i++){
			TabDisplay tab = new TabDisplay(i);
			JScrollPane pane = new JScrollPane(tab);
			add(pane, tab_names[i-1]);
		}
	}

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
	
	//********Random Schedule Generator********\\
	public static LinkedList<EmployeeTimeSlot> generateSchedule(String s_day, LinkedList<String> positions, LinkedList<EmployeeTimeSlot> day, LinkedList<Employee> employee_list) {
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
		
		for(EmployeeTimeSlot t : day) { 
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
	
	private class TabDisplay extends JPanel{
	
		public static final int TABLE_WIDTH = 70;
		public static final int TABLE_HEIGHT = 30;
		private final String[] TABLE_HEADERS = {"12:00 am","1:00 am","2:00 am","3:00 am","4:00 am","5:00 am","6:00 am","7:00 am","8:00 am","9:00 am","10:00 am", "11:00 am","12:00 pm","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm"};
		private final int day;
		
		public TabDisplay(int day){
			this.day = day;
			
			LinkedList<EmployeeTimeSlot> slots = getDaysTimeSlots(day);
			int collumn_one_wdth = 100;
			setMinimumSize(new Dimension(collumn_one_wdth+TABLE_HEADERS.length*TABLE_WIDTH, TABLE_HEIGHT*slots.size()));
			setPreferredSize(new Dimension(collumn_one_wdth+TABLE_HEADERS.length*TABLE_WIDTH, TABLE_HEIGHT*slots.size()));
		}
		
		@Override
		public void paint(Graphics g){
			drawTimeSlots(g);
		}
		
		private int last_width = 0;
		
		private void drawTimeSlots(Graphics g){
			g.setColor(Color.black);
			g.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
			
			FontMetrics fm = g.getFontMetrics();
			
			// Get the max width of users names
			LinkedList<EmployeeTimeSlot> slots = getDaysTimeSlots(day);
			int collumn_one_wdth = 100;
			for(EmployeeTimeSlot ets : slots){
				int string_wdth = fm.stringWidth(ets.getName());
				if(string_wdth > collumn_one_wdth)
					collumn_one_wdth = string_wdth+10;
			}
			
			if(collumn_one_wdth != last_width){
				last_width = collumn_one_wdth;
				setMinimumSize(new Dimension(collumn_one_wdth+TABLE_HEADERS.length*TABLE_WIDTH, TABLE_HEIGHT*slots.size()));
				setPreferredSize(new Dimension(collumn_one_wdth+TABLE_HEADERS.length*TABLE_WIDTH, TABLE_HEIGHT*slots.size()));
			}
			
			// Draw the table header
			g.drawRect(0, 0, collumn_one_wdth, TABLE_HEIGHT);
			int string_width_t = fm.stringWidth("Name");
			g.drawString("Name", (collumn_one_wdth-string_width_t)/2, TABLE_HEIGHT-7);
			
			for(int i=0 ; i<TABLE_HEADERS.length ; i++){
				g.drawRect(collumn_one_wdth+TABLE_WIDTH*i, 0, TABLE_WIDTH, TABLE_HEIGHT);
				int string_width = fm.stringWidth(TABLE_HEADERS[i]);
				g.drawString(TABLE_HEADERS[i], collumn_one_wdth+TABLE_WIDTH*i+(TABLE_WIDTH-string_width)/2, TABLE_HEIGHT-7);
			}
			
			// Draw people that are scheduled
			int row = 1;
			
			for(EmployeeTimeSlot slot : slots){
				for(int i=0 ; i<TABLE_HEADERS.length ; i++){
					g.drawRect(collumn_one_wdth+TABLE_WIDTH*i, 0, TABLE_WIDTH, TABLE_HEIGHT);
				}

				String name = slot.getName();
				int name_width = fm.stringWidth(name);
				String position = "("+slot.getPosition()+")";
				int position_width = fm.stringWidth(position);
				double total_time = slot.getEnd()-slot.getBegin();
				int graphic_width = (int) (TABLE_WIDTH * total_time);
				int left_x = (int) (collumn_one_wdth + TABLE_WIDTH * slot.getBegin());
				
				g.setColor(Color.blue);
				g.fillRect(left_x, row*TABLE_HEIGHT, graphic_width, TABLE_HEIGHT);
				
				g.setColor(Color.black);
				g.drawString(name, (collumn_one_wdth-name_width)/2, (row+1)*TABLE_HEIGHT-9);
				g.drawString(position, left_x+(graphic_width-position_width)/2, (row+1)*TABLE_HEIGHT-9);

				g.drawLine(0, row*TABLE_HEIGHT, 0, (row+1)*TABLE_HEIGHT);
				g.drawLine(collumn_one_wdth, row*TABLE_HEIGHT, collumn_one_wdth, (row+1)*TABLE_HEIGHT);
				g.drawLine(0, (row+1)*TABLE_HEIGHT, collumn_one_wdth+TABLE_WIDTH*TABLE_HEADERS.length, (row+1)*TABLE_HEIGHT);
				g.drawLine(collumn_one_wdth+TABLE_WIDTH*TABLE_HEADERS.length, (row+1)*TABLE_HEIGHT, collumn_one_wdth+TABLE_WIDTH*TABLE_HEADERS.length, row*TABLE_HEIGHT);
				g.drawString(position, left_x+(graphic_width-position_width)/2, (row+1)*TABLE_HEIGHT-9);
			
				row++;
			}
		}
	
	}
	
	private LinkedList<EmployeeTimeSlot> getDaysTimeSlots(int day){
		switch(day){
		case(1):
			return sunday;
		case(2):
			return monday;
		case(3):
			return tuesday;
		case(4):
			return wednesday;
		case(5):
			return thursday;
		case(6):
			return friday;
		default:
			return saturday;
		}
	}

	public void mouseDrop(Point mouse_loc, Employee employee) {
		Insets in = new Insets(26, 4, 0, 0);
		mouse_loc.x -= in.left;
		mouse_loc.y -= in.top;
		
		int time_id = mouse_loc.y/TabDisplay.TABLE_HEIGHT;

		LinkedList<EmployeeTimeSlot> slots = getDaysTimeSlots(this.getSelectedIndex()+1);
		
		if(time_id > 0 && time_id <= slots.size()){
			EmployeeTimeSlot em = slots.get(time_id-1);
			
			em.setName(employee.getName());
		}
	}

}
