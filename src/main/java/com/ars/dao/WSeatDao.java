package com.ars.dao;

import java.util.List;

import com.ars.entity.WSeat;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Dao Interface
 *
 * 
 */
public interface WSeatDao {
	/**
	 * 
	 * @param no seatnumber
	 * @return ticket deletion status
	 */
	public String deleteByAadharId(long no);
	/**
	 * 
	 * @param FlightId
	 * @return seatStatusList
	 * @description method to get status of list of all the seats based on FlightId
	 */
	public List<WSeat> getAllSeatStatus(int FlightId);
	/**
	 * 
	 * @param seatId
	 * @return wSeat 
	 *
	 */
	public WSeat getSeatByAadharId(long seatId);
	/**
	 * 
	 * @param no seatnumber
	 * @return seatStatus
	 */
	public String getSeatStatusById(int no);}
