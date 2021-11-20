package com.ars.dao;

import java.util.List;

import com.ars.entity.User;

public interface UserDao {
	public String addUser(User user);
	public List<User> getAllUser();
	public User getAUser(String emailid);
	public void updateUser(User user);
	public void deleteUser(String emailid);
	public User searchByIdAndPassword(String emailid,String password);
}
