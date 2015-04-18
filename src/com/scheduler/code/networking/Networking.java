package com.scheduler.code.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

	public DataPackage pullData() {
		DataPackage data = new DataPackage();
		
		
		
		return data;
	}
	
}
