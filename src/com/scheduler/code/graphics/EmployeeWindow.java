package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;

import com.scheduler.code.employees.Employee;

public class EmployeeWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8525299699136290656L;
	JFrame parent;
	
	public static void main(String[] args) {
		JFrame derp = new JFrame();
		derp.setVisible(true);
		new EmployeeWindow(derp);
	}
	public EmployeeWindow(JFrame frame, Employee e) {
		this(frame);
	}
	
	public EmployeeWindow(JFrame frame) {
		super("Employee Edit Manager");
		
		parent = frame;
		frame.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		String[] labels = {"First: ", "Last: ", "Middle: ", "DOB (mm/dd/yyyy): ", "/", "/", "SSN: ", "-", "-", "Phone Number: ", "-", "-", "Address: ", "City: ", "State: ", "Zip: ", "Pay Rate: "};
		int label_length = labels.length;
		Font font = new Font("Courier", Font.BOLD,30);
		
		JPanel content = new JPanel(new BorderLayout());
		
		JPanel right_col = new JPanel(new SpringLayout());
		ListModel model = new DefaultListModel();
		JScrollPane pane = new JScrollPane(new JList(model));
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		content.add(pane, BorderLayout.LINE_START);
		for(int i = 0; i < label_length; i++) {
			 JLabel l = new JLabel(labels[i], JLabel.TRAILING); 
			 l.setFont(font); 
			 right_col.add(l); 
			 JTextField textField = new JTextField(10); 
			 textField.setFont(font);
			 l.setLabelFor(textField); 
			 right_col.add(textField);
		}
	   
	    content.add(right_col, BorderLayout.LINE_END);
	 
	        //Lay out the panel.
	    SpringUtilities.makeCompactGrid(right_col,
	    		 							5, 6, //rows, cols
	                                        6, 6,        //initX, initY
	                                        6, 6);       //xPad, yPad
		
		
		setContentPane(content);
		pack();
		setLocationRelativeTo(frame);
		setVisible(true);
		
		addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	void close(){
		//re enable frame
		parent.setEnabled(true);
		System.exit(0);
	}
	
	
}
