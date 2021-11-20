package com.ars.exception;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 * @author "Vinaya Rekha Parimi"
	 * @version "1.0"
	 * @category Exception
	 * @usage   avoiding abnormal termination of program w.r.t exceptions regarding User
	 * 
	 */
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
