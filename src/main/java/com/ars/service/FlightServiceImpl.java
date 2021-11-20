package com.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.dao.FlightDao;
import com.ars.entity.Flight;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{

	@Autowired 
	FlightDao flightDao;
	
	@Override
	public String addFlightDetails(Flight flight) {
		return flightDao.addFlightDetails(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
	
		return flightDao.getAllFlights();
	}

	@Override
	public String updateFlight(Flight flight) {
		return flightDao.updateFlight(flight); 		
	}

	@Override
	public Flight getFlight(int flId) {
		
	return flightDao.getFlight(flId);	}

	@Override
	public void deleteUser(int flId) {
            flightDao.deleteFlight(flId);
		
	}

	@Override
	public List<Flight> getBySrcAndDes(String src, String des) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public Flight getBySrcAndDes(String src, String des) {
		// TODO Auto-generated method stub
		//return flightDao.getBySrcAndDes(src, des);
	}


