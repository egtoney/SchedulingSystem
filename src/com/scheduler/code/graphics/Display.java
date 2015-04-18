package com.scheduler.code.graphics;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.scheduler.code.Main;

public class Display extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -600606304619369617L;

	private static int DEFAULT_SCREEN_WIDTH = 800;
	private static int DEFAULT_SCREEN_HEIGHT = 600;
	
	public Display(Main m){
		super(null);
		
		setMinimumSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
		setPreferredSize(new Dimension(DEFAULT_SCREEN_WIDTH, DEFAULT_SCREEN_HEIGHT));
	}
	
}
