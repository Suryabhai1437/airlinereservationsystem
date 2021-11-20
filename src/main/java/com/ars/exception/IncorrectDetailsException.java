package com.ars.exception;

public class IncorrectDetailsException extends RuntimeException{
	
	public IncorrectDetailsException()
	{
		super();
	}
	public IncorrectDetailsException(String msg)
	{
		super(msg);
	}

}
