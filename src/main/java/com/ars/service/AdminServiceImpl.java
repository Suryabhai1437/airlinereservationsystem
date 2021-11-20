package com.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.dao.AdminDao;
import com.ars.entity.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

//	@Autowired
//	AdminDao adminDao;
//	@Override
//	public void save(Admin admin) {
//		
//		adminDao.save(admin);
//	}

}
