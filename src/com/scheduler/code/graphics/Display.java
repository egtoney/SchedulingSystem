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
import com.scheduler.code.networking.DataPackage;
import com.scheduler.code.networking.Networking;
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
					// TODO Auto-generated method stub
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
		
		menu.add(schedule);
		
		parent.setJMenuBar(menu);
		
		// put all of the graphical interfaces on the pane
		ScheduleScreen scrn = new ScheduleScreen(running_schedule, data);
		
		room_contense.push(scrn);
		add(scrn, BorderLayout.CENTER);
	}
	
}
