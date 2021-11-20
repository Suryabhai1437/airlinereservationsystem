package com.ars.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.entity.WSeat;
import com.ars.entity.Ticket;
import com.ars.entity.User;


@Repository
public class WSeatDaoImpl implements WSeatDao{


	@Autowired
	SessionFactory sessionFactory;
	public static final String GET_A_SEAT_BY_ID= "from WSeat where aadharId=:aadharId";
	public static final String GET_ALL_SEAT_STATUS= "from WSeat where flightId=:flightId";
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public WSeat getSeatByAadharId(long aadharId) {
		
		Query query = getSession().createQuery(GET_A_SEAT_BY_ID);
		query.setParameter("aadharId", aadharId);
		WSeat wSeat = (WSeat) query.uniqueResult();
		System.out.println(wSeat);
		return wSeat;	
		}
//	@Override
//	public void deleteSeat(int flId) {
//		Query qry = getSession().createQuery(DELETE_A_FLIGHT);
//
//		System.out.println("From dao" + flId);
//		qry.setParameter("flId", flId);
//		int totalrows = qry.executeUpdate();
//
//		System.out.println("totalrows=" + totalrows);
//		if (totalrows > 0) {
//			System.out.println("deleted successfully from dao");
//
//		}
//
//	}

	@Override
	public List<WSeat> getAllSeatStatus(int flightId) {
		
		
		Query qry = getSession().createQuery(GET_ALL_SEAT_STATUS);
		qry.setParameter("flightId", flightId);
		System.out.println("from dao"+flightId);
	
			List<WSeat> seatStatusList = qry.list();
			System.out.println(seatStatusList);
		return seatStatusList;
	}
	
	@Override
	public String getSeatStatusById(int no)
	{
		 Query query = getSession().createQuery("SELECT s.seatStatus FROM WSeat s WHERE s.seatNo=:no");
		    query.setParameter("no", no);
		    return (String)query.uniqueResult();
	}
	@Override
	public String deleteByAadharId(long no)
	{
		 Query query = getSession().createQuery("delete WSeat where aadharId=:no");
		    query.setParameter("no", no);
		    int rows = query.executeUpdate();
		    if(rows>0)
		    {
		    	System.out.println("executed successfully");
		    }
		    return "done";
	}
}