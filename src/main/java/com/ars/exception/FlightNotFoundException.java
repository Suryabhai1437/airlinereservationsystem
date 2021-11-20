package com.ars.exception;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Exception
 * @usage   avoiding abnormal termination of program w.r.t exceptions regarding FlightData
 * 
 */
public class FlightNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public FlightNotFoundException() {
		super();
	}
	
	public FlightNotFoundException(String msg) {
		super(msg);
	}

}
