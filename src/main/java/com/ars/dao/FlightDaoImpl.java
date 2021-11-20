package com.ars.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.entity.Flight;
import com.ars.entity.User;

@Repository
public class FlightDaoImpl implements FlightDao {
	@Autowired
	SessionFactory sessionFactory;

	public static final String GET_ALL_FLIGTHS = "from Flight";
	public static final String GET_A_FLIGHT = "from Flight where flId=:flId";
	public static final String DELETE_A_FLIGHT = "delete Flight where flId=:flId";
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String addFlightDetails(Flight flight) {

		flight.setTotalAvailableSeat(0);
		flight.setTotalBookedSeat(0);
		getSession().saveOrUpdate(flight);
		System.out.println("Flight Stored Successfully :)");

		return "added successfully";
	}

	@Override
	public List<Flight> getAllFlights() {
		Query qry = getSession().createQuery(GET_ALL_FLIGTHS);
		List<Flight> flightList = qry.list();
		return flightList;
	}

	@Override
	public String updateFlight(Flight flight) {

		flight.setSrcTime(flight.getSrcTime());
		flight.setDesTime(flight.getDesTime());
		flight.setStartDes(flight.getStartDes());
		flight.setEndDes(flight.getEndDes());
		flight.setFlDate(flight.getFlDate());
		flight.setAirlineName(flight.getAirlineName());
		flight.setClassPrice(flight.getClassPrice());
		flight.setFlName(flight.getFlName());
		flight.setTotalAvailableSeat(flight.getTotalAvailableSeat());
		flight.setTotalBookedSeat(flight.getTotalBookedSeat());
		flight.setTotalSeat(flight.getTotalSeat());

		getSession().update(flight);
		return "updated successfully";
	}

	@Override
	public Flight getFlight(int flId) {
		Query query = getSession().createQuery(GET_A_FLIGHT);
		query.setParameter("flId", flId);
		Flight flight = (Flight) query.uniqueResult();
		System.out.println(flight);
		return flight;

	}

	@Override
	public void deleteFlight(int flId) {
		Query qry = getSession().createQuery(DELETE_A_FLIGHT);

		System.out.println("From dao" + flId);
		qry.setParameter("flId", flId);
		int totalrows = qry.executeUpdate();

		System.out.println("totalrows=" + totalrows);
		if (totalrows > 0) {
			System.out.println("deleted successfully from dao");

		}

	}

	@Override
	public List<Flight> getBySrcAndDes(String src, String des) {
		Criteria c = getSession().createCriteria(Flight.class);
		c.add(Restrictions.and(Restrictions.eq("startDes", src), Restrictions.eq("endDes", des)));
		List<Flight> flightList = c.list();

		return flightList;
	}

}
