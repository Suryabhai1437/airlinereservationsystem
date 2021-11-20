package com.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.dao.TicketDao;
import com.ars.entity.Ticket;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketDao ticketDao;
	
	@Override
	public void addBooking(Ticket ticket) {
		
		ticketDao.addBooking(ticket);
	}

	@Override
	public Ticket getTicketByid(long ticketId) {
		
		return ticketDao.getTicketByid(ticketId);
	}

	@Override
	public void cancelTicket(long aadharId,int flId) {
		
		ticketDao.cancelTicket(aadharId,flId);
	}

}
