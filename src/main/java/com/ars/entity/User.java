package com.ars.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * 
 * @author Vinaya Rekha Parimi
 * @version 1.0
 * @category Entity
 * @description Entity to provide details of Passengers
 *
 */
@Entity

@Table(name = "User1")
public class User {
	@Id
	private String emailId;

	private String password;

	private String gender;

	@Embedded
	private UserName userName;

	@Embedded
	private Phone phone;

	private String country;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Ticket> ticket;

	public User() {
		super();

	}

	
/**
 * 
 * @param emailId
 * @param password
 * @param gender
 * @param userName
 * @param phone
 * @param country
 * @param ticket
 * @description Constructor for User Entity class
 */
	public User(String emailId, String password, String gender, UserName userName, Phone phone, String country,
			List<Ticket> ticket) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.userName = userName;
		this.phone = phone;
		this.country = country;
		this.ticket = ticket;
	}

/**
 * 
 * @return userName
 * @description method to get username
 */

	public UserName getUserName() {
		return userName;
	}
/**
 * 

 * @param userName
 * @description method to set username
 */
	public void setUserName(UserName userName) {
		this.userName = userName;
	}
/**
 * 
 * @return emailId
 * @description method to get Email ID
 */
	public String getEmailId() {
		return emailId;
	}
/**
 * 
 * @param emailId
 * @description method to set Email ID
 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
/**
 * 
 * @return password
 * @description method to get password
 */
	public String getPassword() {
		return password;
	}
/**
 * 
 * @param password
 * @description method to set password
 */
	public void setPassword(String password) {
		this.password = password;
	}
/**
 * 
 * @return password
 * @description method to get Gender
 */
	public String getGender() {
		return gender;
	}
/**
 * 
 * @param gender
 * @description method to set gender
 */
	public void setGender(String gender) {
		this.gender = gender;
	}
/**
 * 
 * @return phone
 * @description method to get Phone
 */
	public Phone getPhone() {
		return phone;
	}
/**
 * 
 * @param phone
 * @description method to set phone
 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
/**
 * 
 * @return country
 * @description method to get country
 */
	public String getCountry() {
		return country;
	}
/**
 * 
 * @param country
 * @description method to set country
 */
	public void setCountry(String country) {
		this.country = country;
	}
	

//	public List<Ticket> getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(List<Ticket> ticket) {
//		this.ticket = ticket;
//	}
/**
 * 
 * @return Method to give User entity details
 */
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", gender=" + gender + ", userName=" + userName
				+ ", phone=" + phone + ", country=" + country + ", ticket=" + ticket + "]";
	}

	
}
