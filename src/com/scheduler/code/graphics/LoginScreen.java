package com.scheduler.code.graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.scheduler.code.networking.Networking;
import com.scheduler.code.networking.UserAuthenticationError;

public class LoginScreen extends JPanel{

	private static final int FIELD_WIDTH = 150;
	private static final int FIELD_HEIGHT = 30;
	
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	
	public LoginScreen(final Display parent){
		
		JPanel content = new JPanel(new GridLayout(3,2));
		content.add(new JLabel("Username"));
		content.add(username);
		content.add(new JLabel("Password"));
		content.add(password);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		content.add(close);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					Networking connection = new Networking(username.getText(), password.getPassword());
					parent.onLogin(connection);
					
				}catch(UserAuthenticationError e){
					System.out.println("Failed to log in!");
				}
			}
			
		});
		content.add(login);
		
		content.setPreferredSize(new Dimension(2*FIELD_WIDTH, 2*FIELD_HEIGHT));
		
		add(content);
	}
	
}
