package com.ars.entity;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
/**
 * 
 * @author Vinaya Rekha Parimi
 * @version 1.0
 * @category Entity
 * @description This entity provides user name details 
 *
 */
@Embeddable

public class UserName {

	private String firstName;
	private String lastName;
	/**
	 * 
	 * @return firstName
	 * @description method to get firstname
	 */
	public String getFirstName() {
		return firstName;
	}
/**
 * 
 * @param firstName
 * @description method to set firstname
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * 
 * @return lastName
 * @description method to get lastname
 */
	public String getLastName() {
		return lastName;
	}
/**
 * 
 * @param lastName
 * @description method to set lastname
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

/**
 * 
 * @return method to retrieve User array details 	
 */
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
