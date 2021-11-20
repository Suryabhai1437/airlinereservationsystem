package com.ars.exception;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Exception
 * @usage   avoiding abnormal termination of program w.r.t exceptions regarding IncorrectDetails
 * 
 */
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
