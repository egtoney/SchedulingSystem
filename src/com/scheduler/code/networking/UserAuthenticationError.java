package com.scheduler.code.networking;

public class UserAuthenticationError extends Error{

	public UserAuthenticationError(){
		super("User information is not valid");
	}
	
}
