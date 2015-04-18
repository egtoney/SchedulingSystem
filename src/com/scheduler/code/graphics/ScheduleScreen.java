package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.scheduler.code.employees.Employee;
import com.scheduler.code.networking.DataPackage;
import com.scheduler.code.scheduler.RawSchedule;

public class ScheduleScreen extends JPanel implements MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381024356244792035L;
	private boolean mouse_pressed = false;
	private int employee_focus = -1;
	private DataPackage dp;
	
	private JScrollPane elPane;
	private EmployeeList el;
	
	private Point mouse_location;
	
	private RawSchedule running_schedule;
	
	public ScheduleScreen(RawSchedule running_schedule, final DataPackage dp){
		super(new BorderLayout());
		
		this.running_schedule = running_schedule;
		this.dp = dp;
		
		el = new EmployeeList(dp.getEmployeeList());
		elPane = new JScrollPane(el);
		elPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		elPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		elPane.setBackground(Color.black);
		elPane.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!mouse_pressed){
					mouse_pressed = true;
					Point mouse_loc = arg0.getPoint();
					employee_focus = mouse_loc.y/EmployeeNameplate.HEIGHT;
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				//drop the employee into the schedule
				if(mouse_pressed && employee_focus != -1){
					Point mouse_loc = arg0.getPoint();
					Rectangle rect = elPane.getBounds();
					mouse_loc.x += rect.x;
					if(!rect.contains(mouse_loc)){
						//TODO
						System.out.println("Dropped "+dp.getEmployeeList().get(employee_focus).getName()+" on the schedule at "+mouse_loc);
					}
				}
				employee_focus = -1;
				mouse_pressed = false;
			}
			
		});
		elPane.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				mouse_location = arg0.getPoint();
				mouse_location.x += elPane.getX();
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				mouse_location = arg0.getPoint();
				mouse_location.x += elPane.getX();
			}
			
		});
		add(elPane, BorderLayout.LINE_END);
		
		add(running_schedule, BorderLayout.CENTER);
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		if(employee_focus != -1){
			EmployeeNameplate plate = el.getNameplate(employee_focus);
			Graphics tg = g.create(mouse_location.x, mouse_location.y, EmployeeNameplate.WIDTH, EmployeeNameplate.HEIGHT);
			plate.paint(tg);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//drop the employee into the schedule
		if(mouse_pressed && employee_focus != -1){
			Point mouse_loc = arg0.getPoint();
			//TODO
			System.out.println("Dropped "+dp.getEmployeeList().get(employee_focus).getName()+" on the schedule at "+mouse_loc);
		}
		employee_focus = -1;
		mouse_pressed = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouse_location = arg0.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouse_location = arg0.getPoint();
	}
	
	public static class EmployeeList extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4029685113873468966L;

		private LinkedList<EmployeeNameplate> fields = new LinkedList<>();
		
		public EmployeeList(LinkedList<Employee> list){
			super(null);

			setMinimumSize(new Dimension(EmployeeNameplate.WIDTH, list.size()*EmployeeNameplate.HEIGHT));
			setPreferredSize(new Dimension(EmployeeNameplate.WIDTH, list.size()*EmployeeNameplate.HEIGHT));
			
			for( Employee e : list ){
				EmployeeNameplate n = new EmployeeNameplate(e);
				fields.add(n);
			}
		}
		
		public EmployeeNameplate getNameplate(int id){
			return fields.get(id);
		}
		
		@Override
		public void paint(Graphics g){
			for(int i=0 ; i<fields.size() ; i++){
				Graphics sub = g.create(0, i*EmployeeNameplate.HEIGHT, EmployeeNameplate.WIDTH, EmployeeNameplate.HEIGHT);
				fields.get(i).paint(sub);
			}
		}
		
	}
	
	public static class EmployeeNameplate extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4414790150089700259L;

		public static final int WIDTH = 300;
		public static final int HEIGHT = 50;
		private Employee e;
		
		public EmployeeNameplate(Employee e){
			super(null);
			this.e = e;
			
			setMaximumSize(new Dimension(WIDTH, HEIGHT));
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
		}
		
		@Override
		public void paint(Graphics g){
			g.setColor(Color.gray);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			
			g.setColor(Color.black);
			g.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 25));
			g.drawString(e.getName(), 5, HEIGHT-15);
			
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(WIDTH-HEIGHT+5, 5, HEIGHT-10, HEIGHT-10);
			
			g.drawRect(WIDTH-2*(HEIGHT-5), 5, HEIGHT-10, HEIGHT-10);
		}
		
	}
	
}
