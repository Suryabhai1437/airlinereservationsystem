package com.ars.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.entity.Flight;
import com.ars.entity.WSeat;
import com.ars.entity.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	WSeat wSeat;
	@Autowired
	Flight flight;
	@Autowired
	FlightDao flightDao;
	@Autowired
	WSeatDao wSeatDao;

	public static final String DELETE_A_TICKET = "delete Ticket where aadharId=:aadharId";

	public static final String GET_A_TICKET_BY_ID = "from Ticket where aadharId=:aadharId";

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addBooking(Ticket ticket) {
		String status = wSeatDao.getSeatStatusById(ticket.getSeatNo());
		if(status!="true")
		{
		getSession().saveOrUpdate(ticket);
		
		Flight flight = flightDao.getFlight(ticket.getFlight().getFlId());
		flight.setTotalBookedSeat(flight.getTotalBookedSeat() + 1);
		flight.setTotalAvailableSeat(flight.getTotalSeat() - flight.getTotalBookedSeat());
		System.out.println("flight from ticket"+flight);
		System.out.println("from ticket"+ticket.getFlight().getFlId());
		wSeat.setAadharId(ticket.getAadharId());
		wSeat.setFlightId(ticket.getFlight().getFlId());
		System.out.println(wSeat.getFlightId());
		wSeat.setSeatNo(ticket.getSeatNo());
		wSeat.setSeatStatus("true");
		getSession().saveOrUpdate(wSeat);
		System.out.println("Flight Stored Successfully :)");
		}
		else
		{
			System.out.println("cant store");
		}
	}

	@Override
	public Ticket getTicketByid(long aadharId) {
		Query query = getSession().createQuery(GET_A_TICKET_BY_ID);
		query.setParameter("aadharId", aadharId);
		Ticket ticket = (Ticket) query.uniqueResult();
		System.out.println(ticket);
		return ticket;
	}

	@Override
	public void cancelTicket(Ticket ticket) {

		wSeatDao.deleteByAadharId(ticket.getAadharId());
		

		System.out.println("From dao" + ticket.getAadharId());
		
		Query qry = getSession().createQuery(DELETE_A_TICKET);
		qry.setParameter("aadharId", ticket.getAadharId());
		int totalrows = qry.executeUpdate();
		Flight flight = flightDao.getFlight(ticket.getFlight().getFlId());
		flight.setTotalBookedSeat(flight.getTotalBookedSeat() - 1);
		flight.setTotalAvailableSeat(flight.getTotalSeat() - flight.getTotalBookedSeat());

		System.out.println("totalrows=" + totalrows);
		if (totalrows > 0) {
			System.out.println("deleted successfully from dao");

		}

	}

}