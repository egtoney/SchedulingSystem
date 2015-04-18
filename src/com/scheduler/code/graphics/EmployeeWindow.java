package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpringLayout;

import com.scheduler.code.employees.Employee;

public class EmployeeWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8525299699136290656L;
	private JFrame parent;
	
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
		Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 15);
		
		JPanel content = new JPanel(new BorderLayout());
		
		// Left Column
		JPanel left_col = new JPanel();
		
		content.add(left_col, BorderLayout.LINE_START);
		
		// RIght Column
		JPanel right_col = new JPanel(new GridLayout(0,1));
		
			JPanel row1 = new JPanel(new FlowLayout());

				JLabel l1 = new JLabel(labels[0]);
				JTextField first_name = new JTextField();
				first_name.setPreferredSize(new Dimension(100,25));
				row1.add(l1);
				row1.add(first_name);
				
				JLabel l2 = new JLabel(labels[1]);
				JTextField last_name = new JTextField();
				last_name.setPreferredSize(new Dimension(100,25));
				row1.add(l2);
				row1.add(last_name);
				
				JLabel l3 = new JLabel(labels[2]);
				JTextField middle_name = new JTextField();
				middle_name.setPreferredSize(new Dimension(100,25));
				row1.add(l3);
				row1.add(middle_name);
			
			right_col.add(row1);
			
			JPanel row2 = new JPanel(new FlowLayout());

				JLabel l4 = new JLabel(labels[3]);
				JTextField birth_month = new JTextField();
				birth_month.setPreferredSize(new Dimension(100,25));
				row2.add(l4);
				row2.add(birth_month);
				
				JLabel l5 = new JLabel(labels[4]);
				JTextField birth_day = new JTextField();
				birth_day.setPreferredSize(new Dimension(100,25));
				row2.add(l5);
				row2.add(birth_day);
				
				JLabel l6 = new JLabel(labels[5]);
				JTextField birth_year = new JTextField();
				birth_year.setPreferredSize(new Dimension(100,25));
				row2.add(l6);
				row2.add(birth_year);
		
			right_col.add(row2);
			
		content.add(right_col, BorderLayout.LINE_END);
		
		
	    JPanel buttons = new JPanel(new FlowLayout());
	    JPanel under = new JPanel(new BorderLayout());
	    JButton delete_selected = new JButton("Delete Selected"); delete_selected.setPreferredSize(new Dimension(200,40));
		JButton submit_changes = new JButton("Submit Changes"); submit_changes.setPreferredSize(new Dimension(200,40));
		JButton add = new JButton("Add"); add.setPreferredSize(new Dimension(100,40));
		JButton cancel = new JButton("Cancel"); cancel.setPreferredSize(new Dimension(150,40));
		buttons.add(delete_selected); buttons.add(submit_changes); buttons.add(add);buttons.add(cancel);
		under.add(buttons, BorderLayout.EAST);
		content.add(under, BorderLayout.PAGE_END);
		
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
		
		delete_selected.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
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
