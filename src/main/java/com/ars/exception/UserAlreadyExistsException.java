package com.ars.exception;

public class UserAlreadyExistsException extends RuntimeException{
	public UserAlreadyExistsException()
	{
		super();
		
	}

	
	public UserAlreadyExistsException(String msg)
	{
		super(msg);
		
	}

}
