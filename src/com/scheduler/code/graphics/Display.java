package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.scheduler.code.Main;
import com.scheduler.code.networking.DataPackage;
import com.scheduler.code.networking.Networking;

public class Display extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -600606304619369617L;

	//parent class
	Main main;
	
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
	
	public Display(Main m){
		super(new BorderLayout());
		main = m;
		
		setMinimumSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
		setPreferredSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
	
		setRoom(LOGIN_SCREEN);
	}

	public void onLogin(Networking connection) {
		//load data
		DataPackage data = connection.pullData();
		
		//TODO pass to classes that care
		
		
		//set display
		setRoom(MAIN_DISPLAY);
	}
	
	void setRoom(int room){
		closeRoom(room);
		openRoom(room);
		curr_room = LOGIN_SCREEN;
	}
	
	void closeRoom(int new_room){
		if(curr_room != new_room){
			//remove current room
			for(JPanel panel : room_contense){
				remove(panel);
			}
		}
	}
	
	void openRoom(int room){
		if(room != curr_room){
			switch(room){
			case(LOGIN_SCREEN):
		        
				LoginScreen l_screen = new LoginScreen(this);
				
				room_contense.push(l_screen);
				add(l_screen, BorderLayout.CENTER);
				break;
			}
		}
	}
	
}
