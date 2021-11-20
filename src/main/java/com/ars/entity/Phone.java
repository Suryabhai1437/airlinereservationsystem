package com.ars.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Entity
 * @description Entity to provide Phone numbers for a particular contact 
 *
 */
@Entity
@Embeddable
public class Phone {
	private long phone1;	
	private long phone2;
	public Phone() {
		super();
		
	}
	
	/**
	 * 
	 * @param phone1
	 * @param phone2
	 * @description constructor method for Phone
	 */
	public Phone(long phone1, long phone2) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	/**
	 * 
	 * @return phone1
	 * @description method to get Primary Phone Number
	 */
	public long getPhone1() {
		return phone1;
	}
	
	/**
	 * 
	 * @param phone1
	 * @description method to set Primary Phone Number
	 */
	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}
	/**
	 * 
	 * @return phone2
	 * @description method to get Secondary Phone Number
	 */
	public long getPhone2() {
		return phone2;
	}
	/**
	 * 
	 * @param phone2
	 * @description method to set Secondary Phone Number
	 */
	public void setPhone2(long phone2) {
		this.phone2 = phone2;
	}
	/**
	 *
	 * @return phone class array
	 * @description method to retrieve Phone entity details
	 */
	@Override
	public String toString() {
		return "Phone [phone1=" + phone1 + ", phone2=" + phone2 + "]";
	}	
	
	
	
}
