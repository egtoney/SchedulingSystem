package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JPanel;

import com.scheduler.code.employees.Employee;
import com.scheduler.code.networking.DataPackage;

public class ScheduleScreen extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381024356244792035L;

	public ScheduleScreen(DataPackage dp){
		super(new BorderLayout());
		
		EmployeeList el = new EmployeeList(dp.getEmployeeList());
		add(el, BorderLayout.LINE_END);
	}
	
	public static class EmployeeList extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4029685113873468966L;

		public EmployeeList(LinkedList<Employee> list){
			super(new GridLayout(0,1));
			
			for( Employee e : list ){
				EmployeeNameplate n = new EmployeeNameplate(e);
				add(n);
			}
		}
		
	}
	
	public static class EmployeeNameplate extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4414790150089700259L;

		private static final int WIDTH = 250;
		private static final int HEIGHT = 50;
		private Employee e;
		
		public EmployeeNameplate(Employee e){
			super(null);
			this.e = e;
		}
		
		@Override
		public void paint(Graphics g){
			g.setColor(Color.gray);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			g.setColor(Color.black);
			g.drawString(e.getName(), 5, HEIGHT-5);
		}
		
	}
	
}
