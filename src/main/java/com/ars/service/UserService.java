package com.ars.service;

import java.util.List;

import com.ars.entity.User;

public interface UserService {
	public String addUser(User user);
	public List<User> getAllUser();
	public User getAUser(String emailid);
	public void updateUser(User user);
	public void deleteUser(String emailid);
	public User searchByIdAndPassword(String emailid,String password);
}
