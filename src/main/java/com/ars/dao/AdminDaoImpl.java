package com.ars.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{
//	@Autowired
//	SessionFactory sessionFactory;
//
//	protected Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	public void save(Admin admin)
//	{
//		getSession().saveOrUpdate(admin);
//	}
}
