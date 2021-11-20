package com.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.dao.WSeatDao;
import com.ars.entity.WSeat;

@Service
@Transactional
public class WSeatServiceImpl implements WSeatService{
	@Autowired
	WSeatDao wSeatDao;

	@Override
	public List<WSeat> getAllSeatStatus(int flightId) {
		// TODO Auto-generated method stub
		return wSeatDao.getAllSeatStatus(flightId);
	}

	@Override
	public String getSeatStatusById(int no) {
		// TODO Auto-generated method stub
		return wSeatDao.getSeatStatusById(no);
	}
	

}