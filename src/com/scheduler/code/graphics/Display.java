package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.scheduler.code.Main;
import com.scheduler.code.employees.Employee;
import com.scheduler.code.networking.DataPackage;
import com.scheduler.code.networking.Networking;
import com.scheduler.code.scheduler.EmployeeTimeSlot;
import com.scheduler.code.scheduler.RawSchedule;

public class Display extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -600606304619369617L;

	//parent class
	Main main;
	JFrame parent;
	
	//init window stuff
	private static int DEFAULT_SCREEN_WIDTH = 800;
	private static int DEFAULT_SCREEN_HEIGHT = 600;
	
	//room management
	private static final int NO_SCREEN = -1;
	private static final int LOGIN_SCREEN = 100;
	private static final int MAIN_DISPLAY = 200;
	private int curr_room = NO_SCREEN;
	
	//room content
	private LinkedList<JPanel> room_contense = new LinkedList<>();
	
	//user data
	private DataPackage data = null;

	private RawSchedule running_schedule;
	
	public Display(Main m, JFrame p){
		super(new BorderLayout());
		main = m;
		parent = p;
		
		setMinimumSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
		setPreferredSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
	
		setRoom(LOGIN_SCREEN);
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
	    RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
	    
	    super.paint(g2);
	}

	public void onLogin(Networking connection) {
		//load data
		data = connection.pullData();
		
		//TODO pass to classes that care
		running_schedule = new RawSchedule(data);
		
		//set display
		setRoom(MAIN_DISPLAY);
	}
	
	private void setRoom(int room){
		closeRoom(room);
		openRoom(room);
		curr_room = room;
	}
	
	private void closeRoom(int new_room){
		if(curr_room != new_room){
			//remove current room
			for(JPanel panel : room_contense){
				remove(panel);
			}
		}
	}
	
	private void openRoom(int room){
		if(room != curr_room){
			switch(room){
			case(LOGIN_SCREEN):
		        
				LoginScreen l_screen = new LoginScreen(this);
				
				room_contense.push(l_screen);
				add(l_screen, BorderLayout.CENTER);
				break;
			case(MAIN_DISPLAY):
				createMainDisplay();
				break;
			}
		}
	}
	
	/**
	 * Is used to initialize the main display since this is a large amount
	 * of code it was separated from the switch statement in setRoom()
	 */
	private void createMainDisplay(){
		//First make the menu bar
		JMenuBar menu = new JMenuBar();
		
		JMenu schedule = new JMenu("Schedule");
		
			JMenuItem auto_gen_schedule = new JMenuItem("Generate Schedule");
			auto_gen_schedule.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//running_schedule
					// TODO Auto-generated method stub
					LinkedList<String> position_list = new LinkedList<String>(); position_list.add("cook"); position_list.add("customer service"); position_list.add("window"); position_list.add("lobby");
					LinkedList<EmployeeTimeSlot> monday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> tuesday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> wednesday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> thursday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> friday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> saturday = new LinkedList<EmployeeTimeSlot>();
					LinkedList<EmployeeTimeSlot> sunday = new LinkedList<EmployeeTimeSlot>();
					
					LinkedList<Employee> employee_list = data.getEmployeeList();
					thursday = RawSchedule.generateSchedule("thursday" , position_list, thursday, employee_list);
					monday = RawSchedule.generateSchedule("monday" , position_list, monday, employee_list);
					friday = RawSchedule.generateSchedule("friday" , position_list, friday, employee_list);
					wednesday = RawSchedule.generateSchedule("wednesday" , position_list, wednesday, employee_list);
					tuesday = RawSchedule.generateSchedule("tuesday" , position_list, tuesday, employee_list);
					sunday = RawSchedule.generateSchedule("sunday" , position_list, sunday, employee_list);
					saturday = RawSchedule.generateSchedule("saturday" , position_list, saturday, employee_list);
					
					RawSchedule r = new RawSchedule(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
					running_schedule = r;
				}
				
			});
			schedule.add(auto_gen_schedule);
		
			JMenuItem submit_schedule = new JMenuItem("Submit Schedule");
			submit_schedule.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				}
				
			});
			schedule.add(submit_schedule);
		
			JMenuItem timer_adder = new JMenuItem("Add Time Slot");
			timer_adder.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					new TimingWindow(Display.this);
				}
				
			});
			schedule.add(timer_adder);
		
		menu.add(schedule);
		
		parent.setJMenuBar(menu);
		
		// put all of the graphical interfaces on the pane
		ScheduleScreen scrn = new ScheduleScreen(running_schedule, data);
		
		room_contense.push(scrn);
		add(scrn, BorderLayout.CENTER);
	}

	//TODO
	public void addTimeSlot(String text, String text2, String pos) {
		try{
			double d1, d2;
			d1 = Double.parseDouble(text);
			d2 = Double.parseDouble(text2);
			running_schedule.addTimeSlot(d1, d2, pos);
		}catch(Error e){
			
		}
	}
	
}
