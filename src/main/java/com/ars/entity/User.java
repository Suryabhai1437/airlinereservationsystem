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



	public UserName getUserName() {
		return userName;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

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

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", gender=" + gender + ", userName=" + userName
				+ ", phone=" + phone + ", country=" + country + ", ticket=" + ticket + "]";
	}

	
}
