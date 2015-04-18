package com.scheduler.code;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import com.scheduler.code.graphics.Display;

public class Main {
	
	private static Thread tick_thread = new Thread(new Tick(), "");
	private static Thread graphics_thread = new Thread(new Graphics(), "");
	
	private static Timer tick_timer = new Timer();
	private static Timer graphics_timer = new Timer();
	
	private static final float TICKS_PER_SECOND = 30;
	private static final float FRAMES_PER_SECOND = 30;
	
	private static final JFrame frame = new JFrame("Hackathon Scheduler");
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		System.out.println("Program Starting!");
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				//init stuff
				Display content = new Display(Main.this, frame);
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setContentPane(content);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				frame.addWindowListener(new WindowListener(){

					@Override
					public void windowActivated(WindowEvent arg0) {
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						close();
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
					}
					
				});
				
				//start threads
				tick_thread.start();
				graphics_thread.start();
			}
			
		});
	}
	
	public void close(){
		frame.dispose();
		System.exit(0);
	}
	
	public static class Tick implements Runnable{

		@Override
		public void run() {
			tick_timer.scheduleAtFixedRate(new TimerTask(){

				@Override
				public void run() {
					
				}
				
			}, 0, (long) (1000.0f/TICKS_PER_SECOND));
		}
		
	}
	
	public static class Graphics implements Runnable{

		@Override
		public void run() {
			graphics_timer.scheduleAtFixedRate(new TimerTask(){

				@Override
				public void run() {
					frame.repaint();
				}
				
			}, 0, (long) (1000.0f/FRAMES_PER_SECOND));
		}
		
	}
	
}
