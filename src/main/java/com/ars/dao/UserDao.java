package com.ars.dao;

import java.util.List;

import com.ars.entity.User;
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Dao Interface
 *
 * 
 */
public interface UserDao {
	/**
	 * 
	 * @param user
	 * @return user
	 * @description method to store new user record
	 */
	public String addUser(User user);
	/**
	 * 
	 * @return passlist passenger list
	 * @description method to retrieve list of passenger records
	 */
	public List<User> getAllUser();
	/**
	 * 
	 * @param emailid
	 * @return user
	 * @description method to get a specific user record based on emailid  
	 */
	public User getAUser(String emailid);
	/**
	 * 
	 * @param user
	 * @description method to update user details
	 */
	public void updateUser(User user);
	/**
	 * 
	 * @param emailid
	 * @description method to delete specific user record based on emailid
	 */
	public void deleteUser(String emailid);
	/**
	 * 
	 * @param emailid
	 * @param password
	 * @return user
	 * @description method to authenticate user credentials and create session for user
	 */
	public User searchByIdAndPassword(String emailid,String password);
}
