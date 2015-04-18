package com.scheduler.code.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import com.scheduler.code.employees.Employee;

public class EmployeeWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8525299699136290656L;
	private JFrame parent;
	private LinkedList<Employee> employee_list = new LinkedList<>();
	private LinkedList<String> position_list = new LinkedList<>();
	
	public static void main(String[] args) {
		JFrame derp = new JFrame();
		LinkedList<Employee> e_list = new LinkedList<>();
		LinkedList<Double> availability = new LinkedList<>();
		LinkedList<String> positions = new LinkedList<>();
		e_list.add(new Employee("A", "blank", "blank", "blank", 99.99, availability, positions, 40, "606-879-6300", "", ""));
		derp.setVisible(true);
		new EmployeeWindow(derp, e_list, positions);
	}
	public EmployeeWindow(JFrame frame, LinkedList<Employee> employee_list, LinkedList<String> position_list, Employee e) {
		this(frame, employee_list, position_list);
	}
	
	public EmployeeWindow(JFrame frame, final LinkedList<Employee> e_l, LinkedList<String> pos_list) {
		super("Employee Edit Manager");
		
		parent = frame;
		employee_list = e_l;
		position_list = pos_list;
		
		frame.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		String[] labels = {"First: ", "Last: ", "Middle: ", "DOB (mm/dd/yyyy): ", "/", "/", "SSN: ", "-", "-", "Phone Number: ", "-", "-", "Address: ", "City: ", "State: ", "Zip: ", "Pay Rate (99.99): ", "Preferred Hours (99):", "Username: ", "Password: "};
		String[] available_hours = new String[48];
		final Double[] available_hours_mirror = new Double[48];
		for(int i = 0; i < 24; i++) {
			available_hours[i*2] = Integer.toString(i)+":00";
			available_hours[i*2+1] = Integer.toString(i)+":30";
			available_hours_mirror[i*2+1] = (double) i;
			available_hours_mirror[i*2+1] = (double) i + 0.5;
		}
	
		Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 15);
		
		JPanel content = new JPanel(new BorderLayout());
		
		// Left Column
		JPanel left_col = new JPanel(new BorderLayout());
		
		String[] names = new String[employee_list.size()];
		int i = 0;
		for(Employee e : employee_list) {
			names[i] = (e.getName());
			i++;
		}
		Arrays.sort(names);
		final DefaultListModel<String> model = new DefaultListModel<>();
		final JList<String> list = new JList<>(model);
		for(String s : names) {
			model.addElement(s);
		}
		left_col.add(list);
		
		content.add(left_col, BorderLayout.CENTER);
		
		// Right Column
		JPanel right_col = new JPanel(new GridLayout(0,1));
		
			JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel l1 = new JLabel(labels[0]);
				final JTextField first_name = new JTextField();
				first_name.setPreferredSize(new Dimension(100,25));
				row1.add(l1);
				row1.add(first_name);
				
				JLabel l2 = new JLabel(labels[1]);
				final JTextField last_name = new JTextField();
				last_name.setPreferredSize(new Dimension(100,25));
				row1.add(l2);
				row1.add(last_name);
				
				JLabel l3 = new JLabel(labels[2]);
				final JTextField middle_name = new JTextField();
				middle_name.setPreferredSize(new Dimension(100,25));
				row1.add(l3);
				row1.add(middle_name);
			
			right_col.add(row1);
			
			JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel l4 = new JLabel(labels[3]);
				final JTextField birth_month = new JTextField();
				birth_month.setPreferredSize(new Dimension(100,25));
				row2.add(l4);
				row2.add(birth_month);
				
				JLabel l5 = new JLabel(labels[4]);
				final JTextField birth_day = new JTextField();
				birth_day.setPreferredSize(new Dimension(100,25));
				row2.add(l5);
				row2.add(birth_day);
				
				JLabel l6 = new JLabel(labels[5]);
				final JTextField birth_year = new JTextField();
				birth_year.setPreferredSize(new Dimension(100,25));
				row2.add(l6);
				row2.add(birth_year);
		
			right_col.add(row2);
			
			JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel l7 = new JLabel(labels[6]);
				final JTextField SSN1 = new JTextField();
				SSN1.setPreferredSize(new Dimension(100,25));
				row3.add(l7);
				row3.add(SSN1);
				
				JLabel l8 = new JLabel(labels[7]);
				final JTextField SSN2 = new JTextField();
				SSN2.setPreferredSize(new Dimension(100,25));
				row3.add(l8);
				row3.add(SSN2);
				
				JLabel l9 = new JLabel(labels[8]);
				final JTextField SSN3 = new JTextField();
				SSN3.setPreferredSize(new Dimension(100,25));
				row3.add(l9);
				row3.add(SSN3);
	
			right_col.add(row3);
			
			JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel l10 = new JLabel(labels[9]);
				final JTextField P1 = new JTextField();
				P1.setPreferredSize(new Dimension(100,25));
				row4.add(l10);
				row4.add(P1);
				
				JLabel l11 = new JLabel(labels[10]);
				final JTextField P2 = new JTextField();
				P2.setPreferredSize(new Dimension(100,25));
				row4.add(l11);
				row4.add(P2);
				
				JLabel l12 = new JLabel(labels[11]);
				final JTextField P3 = new JTextField();
				P3.setPreferredSize(new Dimension(100,25));
				row4.add(l12);
				row4.add(P3);
	
			right_col.add(row4);
			
			JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

				JLabel l13 = new JLabel(labels[12]);
				final JTextField address = new JTextField();
				address.setPreferredSize(new Dimension(100,25));
				row5.add(l13);
				row5.add(address);
				
				JLabel l14 = new JLabel(labels[13]);
				final JTextField city = new JTextField();
				city.setPreferredSize(new Dimension(100,25));
				row5.add(l14);
				row5.add(city);
				
				JLabel l15 = new JLabel(labels[14]);
				final JTextField state = new JTextField();
				state.setPreferredSize(new Dimension(100,25));
				row5.add(l15);
				row5.add(state);
	
			right_col.add(row5);
			
			JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
				JLabel l16 = new JLabel(labels[15]);
				final JTextField zip = new JTextField();
				zip.setPreferredSize(new Dimension(100,25));
				row6.add(l16);
				row6.add(zip);
				
				JLabel l17 = new JLabel(labels[16]);
				final JTextField pay_rate = new JTextField();
				pay_rate.setPreferredSize(new Dimension(100,25));
				row6.add(l17);
				row6.add(pay_rate);
				
			right_col.add(row6);
			
			JPanel row15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
				JLabel l18 = new JLabel(labels[17]);
				final JTextField preferred_hours = new JTextField();
				preferred_hours.setPreferredSize(new Dimension(50,25));
				row15.add(l18);
				row15.add(preferred_hours);
				
				JLabel m = new JLabel("Positions: ");
				final DefaultListModel<String> p_model = new DefaultListModel<>();
				final JList<String> p_l = new JList<>(model);
				for(String p : position_list) {
					 p_model.addElement(p);
				}
	
			right_col.add(row15);
			
			JPanel row14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
				JLabel l19 = new JLabel(labels[18]);
				final JTextField username = new JTextField();
				username.setPreferredSize(new Dimension(100,25));
				row14.add(l19);
				row14.add(username);
				
				JLabel l20 = new JLabel(labels[19]);
				final JTextField password = new JTextField();
				password.setPreferredSize(new Dimension(100,25));
				row14.add(l20);
				row14.add(password);
	
			right_col.add(row14);
			
			//Combo boxes
			JPanel row7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel m1 = new JLabel("Monday: ");
				final JComboBox<String> m_begin = new JComboBox<>(available_hours);
				JLabel to = new JLabel("to");
				final JComboBox<String> m_end = new JComboBox<>(available_hours);
				row7.add(m1);
				row7.add(m_begin);
				row7.add(to);
				row7.add(m_end);
				
			right_col.add(row7);
			
			JPanel row8 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel t = new JLabel("Tuesday: ");
				final JComboBox<String> t_begin = new JComboBox<>(available_hours);
				JLabel to1 = new JLabel("to");
				final JComboBox<String> t_end = new JComboBox<>(available_hours);
				row8.add(t);
				row8.add(t_begin);
				row8.add(to1);
				row8.add(t_end);
				
			right_col.add(row8);
			
			JPanel row9 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel w = new JLabel("Wednesday: ");
				final JComboBox<String> w_begin = new JComboBox<>(available_hours);
				JLabel to2 = new JLabel("to");
				final JComboBox<String> w_end = new JComboBox<>(available_hours);
				row9.add(w);
				row9.add(w_begin);
				row9.add(to2);
				row9.add(w_end);
				
			right_col.add(row9);
			
			JPanel row10 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel r = new JLabel("Thursday: ");
				final JComboBox<String> r_begin = new JComboBox<>(available_hours);
				JLabel to3 = new JLabel("to");
				final JComboBox<String> r_end = new JComboBox<>(available_hours);
				row10.add(r);
				row10.add(r_begin);
				row10.add(to3);
				row10.add(r_end);
				
			right_col.add(row10);
			
			JPanel row11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel f = new JLabel("Friday: ");
				final JComboBox<String> f_begin = new JComboBox<>(available_hours);
				JLabel to4 = new JLabel("to");
				final JComboBox<String> f_end = new JComboBox<>(available_hours);
				row11.add(f);
				row11.add(f_begin);
				row11.add(to4);
				row11.add(f_end);
				
			right_col.add(row11);
			
			JPanel row12 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel s = new JLabel("Saturday: ");
				final JComboBox<String> s_begin = new JComboBox<>(available_hours);
				JLabel to5 = new JLabel("to");
				final JComboBox<String> s_end = new JComboBox<>(available_hours);
				row12.add(s);
				row12.add(s_begin);
				row12.add(to5);
				row12.add(s_end);
				
			right_col.add(row12);
		
			JPanel row13 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
				JLabel su = new JLabel("Sunday: ");
				final JComboBox<String> su_begin = new JComboBox<>(available_hours);
				JLabel to6 = new JLabel("to");
				final JComboBox<String> su_end = new JComboBox<>(available_hours);
				row13.add(su);
				row13.add(su_begin);
				row13.add(to6);
				row13.add(su_end);
				
			right_col.add(row13);

			
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
				String name = list.getSelectedValue().toString();
				for(Employee emp : employee_list) {
					if(emp.getName() == name) {
						employee_list.remove(emp);
					}
				}
				model.removeElementAt(list.getSelectedIndex());
			}
		});
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean good = true;
				
				last_name.setBackground(Color.white);
				if(last_name.getText().isEmpty()){
					good = false;
					last_name.setBackground(Color.yellow);
				}
				first_name.setBackground(Color.white);
				if(first_name.getText().isEmpty()){
					good = false;
					first_name.setBackground(Color.yellow);
				}
				middle_name.setBackground(Color.white);
				if(middle_name.getText().isEmpty()){
					good = false;
					middle_name.setBackground(Color.yellow);
				}
				birth_month.setBackground(Color.white);
				if(birth_month.getText().isEmpty()){
					good = false;
					birth_month.setBackground(Color.yellow);
				}
				birth_day.setBackground(Color.white);
				if(birth_day.getText().isEmpty()){
					good = false;
					birth_day.setBackground(Color.yellow);
				}
				birth_year.setBackground(Color.white);
				if(birth_year.getText().isEmpty()){
					good = false;
					birth_year.setBackground(Color.yellow);
				}
				SSN1.setBackground(Color.white);
				if(SSN1.getText().isEmpty()){
					good = false;
					SSN1.setBackground(Color.yellow);
				}
				SSN2.setBackground(Color.white);
				if(SSN2.getText().isEmpty()){
					good = false;
					SSN2.setBackground(Color.yellow);
				}
				SSN3.setBackground(Color.white);
				if(SSN3.getText().isEmpty()){
					good = false;
					SSN3.setBackground(Color.yellow);
				}
				address.setBackground(Color.white);
				if(address.getText().isEmpty()){
					good = false;
					address.setBackground(Color.yellow);
				}
				city.setBackground(Color.white);
				if(city.getText().isEmpty()){
					good = false;
					city.setBackground(Color.yellow);
				}
				state.setBackground(Color.white);
				if(state.getText().isEmpty()){
					good = false;
					state.setBackground(Color.yellow);
				}
				zip.setBackground(Color.white);
				if(zip.getText().isEmpty()){
					good = false;
					zip.setBackground(Color.yellow);
				}
				P1.setBackground(Color.white);
				if(P1.getText().isEmpty()){
					good = false;
					P1.setBackground(Color.yellow);
				}
				P2.setBackground(Color.white);
				if(P2.getText().isEmpty()){
					good = false;
					P2.setBackground(Color.yellow);
				}
				P3.setBackground(Color.white);
				if(P3.getText().isEmpty()){
					good = false;
					P3.setBackground(Color.yellow);
				}
				pay_rate.setBackground(Color.white);
				if(pay_rate.getText().isEmpty()){
					good = false;
					pay_rate.setBackground(Color.yellow);
				}
				preferred_hours.setBackground(Color.white);
				if(preferred_hours.getText().isEmpty()){
					good = false;
					preferred_hours.setBackground(Color.yellow);
				}
				username.setBackground(Color.white);
				if(username.getText().isEmpty()){
					good = false;
					username.setBackground(Color.yellow);
				}
				password.setBackground(Color.white);
				if(password.getText().isEmpty()){
					good = false;
					password.setBackground(Color.yellow);
				}
					if(good) { 
						String name = first_name.getText()+" "+last_name.getText()+" "+middle_name.getText();
						for(Employee em : employee_list) {
							if(em.getName() == name) {
								return;
							}
						}
						String DOB = birth_month.getText()+"_"+birth_day.getText()+"_"+birth_year.getText();
						String SSN = SSN1.getText()+"_"+SSN2.getText()+"_"+SSN3.getText();
						String s_address = address.getText()+"_"+city.getText()+"_"+state.getText()+"_"+zip.getText();
						String phone_number = P1.getText()+P2.getText()+P3.getText();
						double d_pay_rate = Double.parseDouble(pay_rate.getText());
						double d_preferred_hours = Double.parseDouble(preferred_hours.getText());
						LinkedList<Double> availability = new LinkedList<>();
						availability.add(available_hours_mirror[m_begin.getSelectedIndex()]); availability.add(available_hours_mirror[m_end.getSelectedIndex()]); availability.add(available_hours_mirror[t_begin.getSelectedIndex()]); availability.add(available_hours_mirror[t_end.getSelectedIndex()]); availability.add(available_hours_mirror[w_begin.getSelectedIndex()]); availability.add(available_hours_mirror[w_end.getSelectedIndex()]); availability.add(available_hours_mirror[r_begin.getSelectedIndex()]); availability.add(available_hours_mirror[r_end.getSelectedIndex()]); availability.add(available_hours_mirror[f_begin.getSelectedIndex()]); availability.add(available_hours_mirror[f_end.getSelectedIndex()]); availability.add(available_hours_mirror[s_begin.getSelectedIndex()]); availability.add(available_hours_mirror[s_end.getSelectedIndex()]); availability.add(available_hours_mirror[su_begin.getSelectedIndex()]); availability.add(available_hours_mirror[su_end.getSelectedIndex()]);
						LinkedList<String> positions = new LinkedList<>();
						String s_username = username.getText();
						String s_password = password.getText();
						Employee new_employee = new Employee(name, DOB, SSN, s_address, d_pay_rate, availability, positions, d_preferred_hours, phone_number, s_password, s_username);
						employee_list.add(new_employee);
						model.addElement(new_employee.getName());
					}
			}
		});
		
		submit_changes.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean good = true;
				
				last_name.setBackground(Color.white);
				if(last_name.getText().isEmpty()){
					good = false;
					last_name.setBackground(Color.yellow);
				}
				first_name.setBackground(Color.white);
				if(first_name.getText().isEmpty()){
					good = false;
					first_name.setBackground(Color.yellow);
				}
				middle_name.setBackground(Color.white);
				if(middle_name.getText().isEmpty()){
					good = false;
					middle_name.setBackground(Color.yellow);
				}
				birth_month.setBackground(Color.white);
				if(birth_month.getText().isEmpty()){
					good = false;
					birth_month.setBackground(Color.yellow);
				}
				birth_day.setBackground(Color.white);
				if(birth_day.getText().isEmpty()){
					good = false;
					birth_day.setBackground(Color.yellow);
				}
				birth_year.setBackground(Color.white);
				if(birth_year.getText().isEmpty()){
					good = false;
					birth_year.setBackground(Color.yellow);
				}
				SSN1.setBackground(Color.white);
				if(SSN1.getText().isEmpty()){
					good = false;
					SSN1.setBackground(Color.yellow);
				}
				SSN2.setBackground(Color.white);
				if(SSN2.getText().isEmpty()){
					good = false;
					SSN2.setBackground(Color.yellow);
				}
				SSN3.setBackground(Color.white);
				if(SSN3.getText().isEmpty()){
					good = false;
					SSN3.setBackground(Color.yellow);
				}
				address.setBackground(Color.white);
				if(address.getText().isEmpty()){
					good = false;
					address.setBackground(Color.yellow);
				}
				city.setBackground(Color.white);
				if(city.getText().isEmpty()){
					good = false;
					city.setBackground(Color.yellow);
				}
				state.setBackground(Color.white);
				if(state.getText().isEmpty()){
					good = false;
					state.setBackground(Color.yellow);
				}
				zip.setBackground(Color.white);
				if(zip.getText().isEmpty()){
					good = false;
					zip.setBackground(Color.yellow);
				}
				P1.setBackground(Color.white);
				if(P1.getText().isEmpty()){
					good = false;
					P1.setBackground(Color.yellow);
				}
				P2.setBackground(Color.white);
				if(P2.getText().isEmpty()){
					good = false;
					P2.setBackground(Color.yellow);
				}
				P3.setBackground(Color.white);
				if(P3.getText().isEmpty()){
					good = false;
					P3.setBackground(Color.yellow);
				}
				pay_rate.setBackground(Color.white);
				if(pay_rate.getText().isEmpty()){
					good = false;
					pay_rate.setBackground(Color.yellow);
				}
				preferred_hours.setBackground(Color.white);
				if(preferred_hours.getText().isEmpty()){
					good = false;
					preferred_hours.setBackground(Color.yellow);
				}
				username.setBackground(Color.white);
				if(username.getText().isEmpty()){
					good = false;
					username.setBackground(Color.yellow);
				}
				password.setBackground(Color.white);
				if(password.getText().isEmpty()){
					good = false;
					password.setBackground(Color.yellow);
				}
					if(good) { 
						String name = first_name.getText()+" "+last_name.getText()+" "+middle_name.getText();
						String DOB = birth_month.getText()+"_"+birth_day.getText()+"_"+birth_year.getText();
						String SSN = SSN1.getText()+"_"+SSN2.getText()+"_"+SSN3.getText();
						String s_address = address.getText()+"_"+city.getText()+"_"+state.getText()+"_"+zip.getText();
						String phone_number = P1.getText()+P2.getText()+P3.getText();
						double d_pay_rate = Double.parseDouble(pay_rate.getText());
						double d_preferred_hours = Double.parseDouble(preferred_hours.getText());
						LinkedList<Double> availability = new LinkedList<>();
						availability.add(available_hours_mirror[m_begin.getSelectedIndex()]); availability.add(available_hours_mirror[m_end.getSelectedIndex()]); availability.add(available_hours_mirror[t_begin.getSelectedIndex()]); availability.add(available_hours_mirror[t_end.getSelectedIndex()]); availability.add(available_hours_mirror[w_begin.getSelectedIndex()]); availability.add(available_hours_mirror[w_end.getSelectedIndex()]); availability.add(available_hours_mirror[r_begin.getSelectedIndex()]); availability.add(available_hours_mirror[r_end.getSelectedIndex()]); availability.add(available_hours_mirror[f_begin.getSelectedIndex()]); availability.add(available_hours_mirror[f_end.getSelectedIndex()]); availability.add(available_hours_mirror[s_begin.getSelectedIndex()]); availability.add(available_hours_mirror[s_end.getSelectedIndex()]); availability.add(available_hours_mirror[su_begin.getSelectedIndex()]); availability.add(available_hours_mirror[su_end.getSelectedIndex()]);
						LinkedList<String> positions = new LinkedList<>();
						String s_username = username.getText();
						String s_password = password.getText();
						for(Employee em : employee_list) {
							if(em.getName() == name) {
								em.setName(name);
								em.setDOB(DOB);
								em.setSSN(SSN);
								em.setAddress(s_address);
								em.setPhoneNumber(phone_number);
								em.setPayRate(d_pay_rate);
								em.setPreferredHours(d_preferred_hours);
								em.setAvailability(availability);
								em.setPositions(positions);
								em.setUsername(s_username);
								em.setPassword(s_password);
								return;
							}
						}
						Employee new_employee = new Employee(name, DOB, SSN, s_address, d_pay_rate, availability, positions, d_preferred_hours, phone_number, s_password, s_username);
						employee_list.add(new_employee);
						model.addElement(new_employee.getName());
					}
			}
		});
		
		
	    cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				close();
			}
			
		});

	}
	

	void close(){
		//re enable frame
		parent.setEnabled(true);
		System.exit(0);
	}
	
	
}
