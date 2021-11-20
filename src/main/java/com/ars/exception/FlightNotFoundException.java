package com.ars.exception;

public class FlightNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public FlightNotFoundException() {
		super();
	}
	public FlightNotFoundException(String msg) {
		super(msg);
	}

}
