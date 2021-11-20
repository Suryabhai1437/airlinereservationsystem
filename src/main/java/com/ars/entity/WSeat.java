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

	public WSeat(int seatNo, String seatStatus, int flightId, long aadharId) {
		super();
		this.seatNo = seatNo;
		this.seatStatus = seatStatus;
		this.flightId = flightId;
		this.aadharId = aadharId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public long getAadharId() {
		return aadharId;
	}

	public void setAadharId(long aadharId) {
		this.aadharId = aadharId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "WSeat [seatNo=" + seatNo + ", seatStatus=" + seatStatus + ", FlightId=" + flightId + ", ticketId="
				+ aadharId + "]";
	}

}