package com.ars.dao;

import com.ars.entity.Ticket;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Dao Interface
 * 
 */
public interface TicketDao {
	/**
	 * 
	 * @param ticket
	 * @description method to record BookDetails
	 */
	public void addBooking(Ticket ticket);
	/**
	 * 
	 * @param ticketId
	 * @return ticket
	 * @description method to retrieve booking details with specific aadharId
	 */
	public Ticket getTicketByid(long aadharId);
	/**
	 * 
	 * @param ticket
	 * @description method to cancel the booked ticket
	 */
	public void cancelTicket(Ticket ticket);
}
