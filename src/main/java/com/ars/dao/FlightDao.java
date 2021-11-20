package com.ars.dao;

import java.util.Date;
import java.util.List;

import com.ars.entity.Flight;
import com.ars.entity.User;

public interface FlightDao {

	public String addFlightDetails(Flight flight);
	public List<Flight> getAllFlights();
	public String updateFlight(Flight flight);
	public Flight getFlight(int flId);
	public void deleteFlight(int flId);
	public List<Flight> getBySrcAndDes(String src,String des);
}
