package com.scheduler.code.graphics;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	private final Display parent;
	
	public LoginScreen(final Display parent){
		this.setLayout(new GridBagLayout());
		
		this.parent = parent;
		
		JPanel content = new JPanel(new GridLayout(0,2));
		JLabel l1 = new JLabel("Username");
		l1.setHorizontalAlignment(JLabel.CENTER);
		content.add(l1);
		content.add(username);
		JLabel l2 = new JLabel("Password");
		l2.setHorizontalAlignment(JLabel.CENTER);
		content.add(l2);
		content.add(password);
		
		password.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				switch(arg0.getKeyCode()){
				case(KeyEvent.VK_ENTER):
					login();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}
			
		});
		
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
				login();
			}
			
		});
		content.add(login);
		
		content.setPreferredSize(new Dimension(2*FIELD_WIDTH, 2*FIELD_HEIGHT));
		
		add(content);
	}
	
	private void login(){
		try{
			Networking connection = new Networking(username.getText(), password.getPassword());
			parent.onLogin(connection);
			
		}catch(UserAuthenticationError e){
			System.out.println("Failed to log in!");
		}
	}
	
}
