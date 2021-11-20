package com.ars.service;

import java.util.Date;
import java.util.List;

import com.ars.entity.Flight;

public interface FlightService {
	public String addFlightDetails(Flight flight); 
	public List<Flight> getAllFlights();
	public String updateFlight(Flight flight);
	public Flight getFlight(int flId);
	public void deleteUser(int flId); 
	public List<Flight> getBySrcAndDes(String src,String des);
}