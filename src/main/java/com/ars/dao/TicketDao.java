package com.ars.dao;

import com.ars.entity.Ticket;

public interface TicketDao {
	public void addBooking(Ticket ticket);
	public Ticket getTicketByid(long aadharId);
	public void cancelTicket(long aadharId,int flId);
}
