package com.ars.service;

import com.ars.entity.Ticket;

public interface TicketService {
	public void addBooking(Ticket ticket);
	public Ticket getTicketByid(long ticketId);
	public void cancelTicket(Ticket ticket); 
}