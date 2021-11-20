package com.ars.service;

import java.util.List;

import com.ars.entity.WSeat;

public interface WSeatService {
	public List<WSeat> getAllSeatStatus(int flightId);
	public String getSeatStatusById(int no);
}