package com.ars.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin1")
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Entity
 * @description This entity contains setter and getter classes related to admin
 * 
 */
public class Admin {
	
	@Id
	private String emailId;
	private String password;
	private String adminName;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param emailId
	 * @param password
	 * @param adminName
	 * @description constructor method for Admin entity
	 */
	
	public Admin(String emailId, String password, String adminName) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.adminName =adminName;
	}

/**
 * 
 * @return emailID
 * @description getter method for Email Id of Admin
 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * 
	 * @param emailId
	 * @description Setter method for Email Id of Admin
	 */
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * 
	 * @return password
	 * @description getter method for password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 * @description Setter method for password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return adminName
	 * @description getter method for Admin Name
	 */
	
	public String getAdminName() {
		return adminName;
	}

   /**
    * 
    * @param adminName
    * @description Setter method for Admin Name
    */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return Adminarray
	 * @description method to retrieve Admin entity array details 	
	 */
	public String toString() {
		return "Admin [emailId=" + emailId + ", password=" + password + ", adminName=" + adminName + "]";
	}

	
}
