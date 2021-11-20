package com.ars.entity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Entity
 * @description This entity contains setter and getter classes related to flight
 *
 */
@Entity
public class Flight {

	@Id
	private int flId;
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern = "HH:MM:SS")
	private String srcTime;

//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern = "HH:MM:SS")
	private String desTime;
	private String endDes;
	private String startDes;

	@Embedded
	private ClassPrice classPrice;

	private String flName;
	private int totalSeat;
	private int totalBookedSeat;
	private int totalAvailableSeat;
	
	private String airlineName;

	@JsonFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date flDate;

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Ticket> ticket;

	
	public Flight() {
		super();

	}
/**
 * 
 * @param flId  FlightID
 * @param srcTime source time
 * @param desTime destination time
 * @param endDes end destination
 * @param startDes start destination
 * @param classPrice 
 * @param flName  FlightName
 * @param totalSeat
 * @param totalBookedSeat
 * @param totalAvailableSeat
 * @param airlineName
 * @param flDate Flight date
 * @param ticket
 * @description constructor for Flight class
 */
	public Flight(int flId, String srcTime, String desTime, String endDes, String startDes, ClassPrice classPrice,
			String flName, int totalSeat, int totalBookedSeat, int totalAvailableSeat,
			String airlineName, Date flDate, List<Ticket> ticket) {
		super();
		this.flId = flId;
		this.srcTime = srcTime;
		this.desTime = desTime;
		this.endDes = endDes;
		this.startDes = startDes;
		this.classPrice = classPrice;
		this.flName = flName;
		this.totalSeat = totalSeat;
		this.totalBookedSeat = totalBookedSeat;
		this.totalAvailableSeat = totalAvailableSeat;
		
		this.airlineName = airlineName;
		this.flDate = flDate;
		this.ticket = ticket;
		
	}
/**
 * 
 * @return airlineName
 * @description method to get Airline Name
 */
	public String getAirlineName() {
		return airlineName;
	}
/**
 * 
 * @param airlineName
 * @description method to set Airline Name
 */
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
/**
 * 
 * @return FlId flightId
 * @description method to get Flight ID
 */
	public int getFlId() {
		return flId;
	}
/**
 * 
 * @param flId flightId
 * @description method to set Flight ID
 */
	public void setFlId(int flId) {
		this.flId = flId;
	}
/**
 * 
 * @return srcTime SourceTime
 * @description method to get Source Time
 */
	public String getSrcTime() {
		return srcTime;
	}
/**
 * 
 * @param srcTime SourceTime
 * @description method to set Source Time
 */
	public void setSrcTime(String srcTime) {
		this.srcTime = srcTime;
	}
/**
 * 
 * @return desTime destination time
 * @description method to get Destination Time
 */
	public String getDesTime() {
		return desTime;
	}
/**
 * 
 * 
 * @param desTime destination time
 * @description method to set Destination Time
 */
	public void setDesTime(String desTime) {
		this.desTime = desTime;
	}
/**
 * 
 * @return flDate FlightDate
 * @description method to get Flight Date
 */
	public Date getFlDate() {
		return flDate;
	}
/**
 * 
 * @param flDate FlightDate
 * @description method to set Flight Date
 */
	public void setFlDate(Date flDate) {
		this.flDate = flDate;
	}
/**
 * 
 * @return endDes end destination
 * @description method to get End Destination
 */
	public String getEndDes() {
		return endDes;
	}
/**
 * 
 * @param endDes end destination
 * @description method to set End Destination
 */
	public void setEndDes(String endDes) {
		this.endDes = endDes;
	}
/**
 * 
 * @return startDes start destination
 * @description method to get Start Destination
 */
	public String getStartDes() {
		return startDes;
	}
/**
 * 
 * @param startDes start destination
 * @description method to set Start Destination
 */
	public void setStartDes(String startDes) {
		this.startDes = startDes;
	}
/**
 * 
 * @return flName FlightName
 * @description method to get Flight Name
 */
	public String getFlName() {
		return flName;
	}
/**
 * 
 * @param flName FlightName
 * @description method to set Flight Name
 */
	public void setFlName(String flName) {
		this.flName = flName;
	}
/**
 * 
 * @return totalSeat
 * @description method to get Total Seat
 */
	public int getTotalSeat() {
		return totalSeat;
	}

	/**
	 * 
	 * @param totalSeat
	 * @description method to set Total Seat
	 */
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
/**
 * 
 * @return totalBookedSeat
 * @description method to get Total Booked Seat count
 */
	public int getTotalBookedSeat() {
		return totalBookedSeat;
	}
/**
 * 
 * @param totalBookedSeat
 * @description method to set Total Booked Seat count
 */
	public void setTotalBookedSeat(int totalBookedSeat) {
		this.totalBookedSeat = totalBookedSeat;
	}
/**
 * 
 * @return totalAvailableSeat
 * @description method to get Total Available Seat count
 */
	public int getTotalAvailableSeat() {
		return totalAvailableSeat;
	}

	/**
	 * 
	 * @param totalAvailableSeat
	 * @description method to set Total Available Seat count
	 */
	public void setTotalAvailableSeat(int totalAvailableSeat) {
		this.totalAvailableSeat = totalAvailableSeat;
	}

	
/**
 * 
 * @return classPrice
 * @description method to get seat price based on type of seat i.e., Business/Economy
 */
	public ClassPrice getClassPrice() {
		return classPrice;
	}
/**
 * 
 * @param classPrice
 * @description method to set seat price based on type of seat i.e., Business/Economy
 */
	public void setClassPrice(ClassPrice classPrice) {
		this.classPrice = classPrice;
	}

	/**
	 * 
	 * @return Flightdetails
	 * @description method to retrieve Flight entity details
	 */
	@Override
	public String toString() {
		return "Flight [flId=" + flId + ", srcTime=" + srcTime + ", desTime=" + desTime + ", endDes=" + endDes
				+ ", startDes=" + startDes + ", classPrice=" + classPrice + ", flName=" + flName + ", totalSeat="
				+ totalSeat + ", totalBookedSeat=" + totalBookedSeat + ", totalAvailableSeat=" + totalAvailableSeat
				+  ", airlineName=" + airlineName + ", flDate=" + flDate + ", ticket="
				+ ticket  + "]";
	}

//	public List<Ticket> getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(List<Ticket> ticket) {
//		this.ticket = ticket;
//	}

}