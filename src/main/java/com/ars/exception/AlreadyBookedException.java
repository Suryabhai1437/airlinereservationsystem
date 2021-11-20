package com.ars.exception;

public class AlreadyBookedException extends RuntimeException{

	public AlreadyBookedException() {
		super();
	}
	public AlreadyBookedException(String msg) {
		super(msg);
	}


	
}
