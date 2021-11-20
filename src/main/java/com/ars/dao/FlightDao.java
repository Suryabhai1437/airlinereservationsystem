package com.ars.dao;

import java.util.List;
import java.util.Date;

import com.ars.entity.Flight;
import com.ars.entity.User;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Dao Interface
 * 
 */

public interface FlightDao {
/**
 * 
 * @param flight
 * @return String i.e Flight status  
 * @description method to add flight details
 */
	public String addFlightDetails(Flight flight);
	/**
	 * 
	 * @return flightList
	 * @description method to retrieve all Flights 
	 */
	public List<Flight> getAllFlights();
	/**
	 * 
	 * @param flight
	 * @return @return String i.e Flight status  
	 * @description method to update flight details
	 */
	public String updateFlight(Flight flight);
	/**
	 * 
	 * @param flId FlightID
	 * @return flight
	 * @description method to retrieve particular flight details
	 */
	public Flight getFlight(int flId);
	/**
	 * 
	 * @param flId FlightID
	 * @description method to delete flight
	 */
	public void deleteFlight(int flId);
	/**
	 * 
	 * @param src s
	 * @param des destination
	 * @return flightList
	 */
	public List<Flight> getBySrcAndDes(String src,String des);
}