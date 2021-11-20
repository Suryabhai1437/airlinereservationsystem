package com.ars.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ars.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private final String GET_ALL_USER = "from User";

	private final String GET_A_USER = "from User where emailId=:emailid";

	private final String DELETE_USER = "delete User where emailId=:emailid";

	@Override
	public String addUser(User user) {

		getSession().saveOrUpdate(user);
		System.out.println("User Stored Successfully :)");

		return user.getEmailId();
	}

	@Override
	public List<User> getAllUser() {

		Query qry = getSession().createQuery(GET_ALL_USER);
		List<User> passlist = qry.list();
		return passlist;

	}

	@Override
	public User getAUser(String EmailId) {

		Query query = getSession().createQuery(GET_A_USER);
		query.setParameter("emailid", EmailId);
		System.out.println(EmailId);
		User user = (User) query.uniqueResult();
		System.out.println(user);
		return user;
	}

	@Override
	public void updateUser(User user) {


		user.setCountry(user.getCountry());
		user.setPhone(user.getPhone());
		user.setUserName(user.getUserName());
		user.setPassword(user.getPassword());
		user.setGender(user.getGender());
		getSession().update(user);
	}

	@Override
	public void deleteUser(String emailid) {
		Query qry = getSession().createQuery(DELETE_USER);
		
		System.out.println("From dao"+emailid);
		qry.setParameter("emailid", emailid);
		int totalrows = qry.executeUpdate();
		
		System.out.println("totalrows="+totalrows);
		if (totalrows > 0) {
			System.out.println("deleted successfully from dao");
			System.out.println("from deletePass dao1");

		}

	}

	@Override
	public User searchByIdAndPassword(String emailid, String password) {
		Criteria c = getSession().createCriteria(User.class);
				c.add(Restrictions.and(Restrictions.eq("emailId", emailid),
						Restrictions.eq("password", password)
						)); 
				User user = (User) c.uniqueResult();
				
		return user;
	}
	
}
