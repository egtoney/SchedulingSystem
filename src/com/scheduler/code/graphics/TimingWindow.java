package com.scheduler.code.graphics;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimingWindow extends JFrame{

	private JTextField lower_bound = new JTextField(10);
	private JTextField upper_bound = new JTextField(10);
	private JTextField position = new JTextField(10);
	private final Display disp;
	
	public TimingWindow(final Display disp){
		super("Time Input");
		this.disp = disp;
		
		disp.setEnabled(false);
		
		JPanel content = new JPanel(new GridLayout(0,1));
		
		JPanel row1 = new JPanel(new FlowLayout());
		
			JLabel l1 = new JLabel("Lower Bound");
			row1.add(l1);
			row1.add(lower_bound);
			
		content.add(row1);
		
		JPanel row2 = new JPanel(new FlowLayout());
		
			JLabel l2 = new JLabel("Upper Bound");
			row2.add(l2);
			row2.add(upper_bound);
			
		content.add(row2);
			
		JPanel row3 = new JPanel(new FlowLayout());
		
			JLabel l3 = new JLabel("Position");
			row3.add(l3);
			row3.add(position);
			
		content.add(row3);
		
		JPanel row4 = new JPanel(new FlowLayout());
		
			JButton submit = new JButton("submit");
			submit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					disp.addTimeSlot(lower_bound.getText(),upper_bound.getText(),position.getText());
					close();
				}
				
			});
			row4.add(submit);
		
			JButton cancel = new JButton("canel");
			cancel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					close();
				}
				
			});
			row4.add(cancel);
			
		content.add(row4);
			
		setContentPane(content);
		
		pack();
		this.setLocationRelativeTo(disp);
		this.setVisible(true);
	}
	
	public void close(){
		this.dispose();
		disp.setEnabled(true);
	}
	
}
