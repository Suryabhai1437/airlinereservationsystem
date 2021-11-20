package com.ars.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Ticket {

	@Id
	private long aadharId;
	private double ticketPrice;

	@Embedded
	private UserName name;

	private int seatNo;

	private String address;
	private String passportNo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date bookingDate;

	@ManyToOne
	@JoinColumn(name = "flId", referencedColumnName = "FLID")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "emailId", referencedColumnName = "EMAILID")
	private User user;

	public Ticket() {
		super();
	}

	public Ticket(long aadharId, double ticketPrice, UserName name, int seatNo, String address, String passportNo,
			Date bookingDate, Flight flight, User user) {
		super();
		this.aadharId = aadharId;
		this.ticketPrice = ticketPrice;
		this.name = name;
		this.seatNo = seatNo;
		this.address = address;
		this.passportNo = passportNo;
		this.bookingDate = bookingDate;
		this.flight = flight;
		this.user = user;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public long getAadharId() {
		return aadharId;
	}

	public void setAadharId(long aadharId) {
		this.aadharId = aadharId;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	

	public UserName getName() {
		return name;
	}

	public void setName(UserName name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Ticket [aadharId=" + aadharId + ", ticketPrice=" + ticketPrice + ", name=" + name + ", seatNo=" + seatNo + ", address=" + address + ", passportNo=" + passportNo
				+ ", bookingDate=" + bookingDate + "]";
	}

}