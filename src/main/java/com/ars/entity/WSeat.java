package com.ars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;
/**
 * 
 * @author Vinaya Rekha Parimi
 * @version 1.0
 * @category Entity
 * @description This Entity returns details related to seat and seat availability for booking 
 *
 */
@Entity
public class WSeat {

	@Id
	private int seatNo;

	private String seatStatus;

	private int flightId;
	

	private long aadharId;

	public WSeat() {
		super();
	}
/**
 * 
 * @param seatNo
 * @param seatStatus
 * @param flightId
 * @param aadharId
 * @description constructor method for seat entity class
 */
	public WSeat(int seatNo, String seatStatus, int flightId, long aadharId) {
		super();
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
		this.flightId = flightId;
		this.aadharId = aadharId;
	}
/**
 * 
 * @return flightId
 * @description method to set Flight ID
 */
	public int getFlightId() {
		return flightId;
	}
/**
 * 
 * @param flightId
 * @description method to get Flight ID
 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
/**
 * 
 * @return aadharId
 * @description method to get aadharId
 */
	public long getAadharId() {
		return aadharId;
	}
/**
 * 
 * @param aadharId
 * @description method to set aadharId
 */
	public void setAadharId(long aadharId) {
		this.aadharId = aadharId;
	}
/**
 * 
 * @return seatNo
 * @description method to get Seat Number
 */
	public int getSeatNo() {
		return seatNo;
	}
/**
 * 
 * @param seatNo
 * @description method to set Seat Number
 */
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
/**
 * 
 * @return seatStatus
 * @description method to get Seat Status
 */
	public String getSeatStatus() {
		return seatStatus;
	}
/**
 * 
 * @param seatStatus
 * @description method to set Seat Status
 */
	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}
/**
 * 
 * @return seat Array
 * @description method to retrieve Seat Array
 */
	@Override
	public String toString() {
		return "WSeat [seatNo=" + seatNo + ", seatStatus=" + seatStatus + ", FlightId=" + flightId + ",aadharId=" + aadharId + "]";
	}

}