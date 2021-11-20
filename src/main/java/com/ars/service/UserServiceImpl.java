package com.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.dao.UserDao;
import com.ars.entity.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Override
	public String addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public User getAUser(String emailid) {
		// TODO Auto-generated method stub
		return userDao.getAUser(emailid);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public void deleteUser(String emailid) {
		userDao.deleteUser(emailid);
		
	}


	@Override
	public User searchByIdAndPassword(String emailid, String password) {
		
		return userDao.searchByIdAndPassword(emailid,password);
	}

}
