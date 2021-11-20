package com.ars.entity;

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
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version 1.0
 * @category Entity
 * @description This entity is to manage ticket booking related information 
 *
 */
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
/**
 * 
 * @param aadharId
 * @param ticketPrice
 * @param name
 * @param seatNo
 * @param address
 * @param passportNo
 * @param bookingDate
 * @param flight
 * @param user
 * @description Constructor method for Ticket Booking entity
 */
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
/**
 * 
 * @return seatNo
 * @description method to get seat No
 */
	public int getSeatNo() {
		return seatNo;
	}
/**
 * 
 * @param seatNo
 * @description method to set seat No
 */
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	/**
	 * 
	 * @return user
	 * @description method to get User
	 */

	public User getUser() {
		return user;
	}
/**
 * 
 * @param user
 * @description method to set User
 */
	public void setUser(User user) {
		this.user = user;
	}
/**
 * 
 * @return flight
 * @description method to get Flight Details
 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * 
	 * @param flight
	 * @description method to set Flight Details
	 */

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
/**
 * 
 * @return ticketId
 * @description method to get Ticket ID
 */
	public long getAadharId() {
		return aadharId;
	}
/**
 * 
 * @param ticketId
 * @description method to set Ticket ID
 * 
 */
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
/**
 * 
 * @return ticketPrice
 * @description method to get Ticket price
 */
	public double getTicketPrice() {
		return ticketPrice;
	}
/**
 * 
 * @param ticketPrice
 * @description method to set Ticket price
 */
	public void setTicket_price(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
/**
 * 
 * @return name
 * @description method to get username
 */
	public UserName getName() {
		return name;
	}
/**
 * 
 * @param name
 * @description method to set username
 */
	public void setName(UserName name) {
		this.name = name;
	}
/**
 * 
 * @return address
 * @description method to get Address of the passenger
 */
	public String getAddress() {
		return address;
	}
/**
 * 
 * @param address
 * @description method to set Address of the passenger
 */
	public void setAddress(String address) {
		this.address = address;
	}
/**
 * 
 * @return passportNo
 * @description method to get PassportNo of the passenger
 */

	public String getPassportNo() {
		return passportNo;
	}
/**
 * 	
 * @param passportNo
 * @description method to set PassportNo of the passenger
 */

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
/**
 * 
 * @return bookingDate
 * @description method to get Bookingdate
 */
	public Date getBookingDate() {
		return bookingDate;
	}
/**
 * 
 * @param bookingDate
 * @description method to set Bookingdate
 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
/**
 * 
 * @param ticketPrice
 * @description method to set TicketPrice
 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	
	@Override
	/**
	 * @return Ticket class
	 * @description method to get Ticket entity array
	 */
	public String toString() {
		return "Ticket [aadharId=" + aadharId + ", ticketPrice=" + ticketPrice + ", name=" + name + ", seatNo=" + seatNo
				+ ", address=" + address + ", passportNo=" + passportNo + ", bookingDate=" + bookingDate + "]";
	}

}