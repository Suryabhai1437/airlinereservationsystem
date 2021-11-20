package com.ars.dao;

import java.util.List;

import com.ars.entity.WSeat;

public interface WSeatDao {
	public WSeat getSeatByAadharId(long seatId);
	public List<WSeat> getAllSeatStatus(int FlightId);
	public String getSeatStatusById(int no);
	public String deleteByAadharId(long no);
}
