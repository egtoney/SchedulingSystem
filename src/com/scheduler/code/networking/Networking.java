package com.scheduler.code.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.scheduler.code.employees.Employee;

public class Networking {
	
	private boolean logged_in = false;
	private String username = "";
	private String password = "";

	public Networking(String name, char[] cs) throws UserAuthenticationError{
		logged_in = attemptLogin(name, cs);
		if(!logged_in)
			throw new UserAuthenticationError();
		
		username = name;
		password = new String(cs);
	}

	public DataPackage pullData() {
		String result = httpRequest("http://glasswatergames.com/schedule/retrieveData.php?u="+username+"&p="+password);

		DataPackage data = new DataPackage(result);
		return data;
	}
	
	public boolean createNewEmployee(Employee e){
		String[] add = e.getAddress().split("_");
		
		String positions = "";
		boolean first = true;
		for(String str : e.getPositions()){
			if(!first){
				positions += ", ";
			}
			first = false;
			positions += str;
		}
		
		String avaiability = "";
		boolean toggle = true;
		first = true;
		for(double s : e.getAvailability()){
			if(!first){
				if(toggle){
					avaiability += "-";
				}else{
					avaiability += ",";
				}
				toggle = (toggle) ? false : true ;
			}
			first = false;
			int hour = (int) (s/1);
			int minutes = (s%1.0 != 0) ? 30 : 0 ;
			avaiability = hour + "_" + minutes;
		}
		
		String request = "http://glasswatergames.com/schedule/createEmloyee.php?u="+username+"&"
				+ "p="+password+"&n_u="+e.getUsername()+"&n_n="+e.getName()+"&"
				+ "n_ph="+e.getPreferredHours()+"&n_pr="+e.getPayRate()+"&n_dob="+e.getDOB()+"&n_ssn="+e.getSSN()+"&"
				+ "n_a="+add[0]+"&n_c="+add[1]+"&n_s="+add[2]+"&n_z="+add[3]+"&n_pn="+e.getPhoneNumber()+"&n_pos="+positions+"&"
				+ "n_ava="+avaiability+"&n_aod=none";
		
		String result = httpRequest(request);
		return (result.charAt(0) == '1') ? true : false;
	}
	
	public static boolean attemptLogin(String username, char[] cs){
		String pass = new String(cs);
		for(char c : cs)
			c = ' ';
		
		String result = httpRequest("http://glasswatergames.com/schedule/login.php?u="+username+"&p="+pass);
		return (result.charAt(0) == '1') ? true : false;
	}
	
	public static String httpRequest(String url){
		String result = "";
		try {
			URL conn = new URL(url);
			URLConnection yc = conn.openConnection();
			BufferedReader in = new BufferedReader(
										new InputStreamReader(
										yc.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) 
				result += inputLine;
			in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
