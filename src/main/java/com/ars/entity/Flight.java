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

@Entity
public class Flight {

	@Id
	private int flId;

	private String srcTime;

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

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getFlId() {
		return flId;
	}

	public void setFlId(int flId) {
		this.flId = flId;
	}

	public String getSrcTime() {
		return srcTime;
	}

	public void setSrcTime(String srcTime) {
		this.srcTime = srcTime;
	}

	public String getDesTime() {
		return desTime;
	}

	public void setDesTime(String desTime) {
		this.desTime = desTime;
	}

	public Date getFlDate() {
		return flDate;
	}

	public void setFlDate(Date flDate) {
		this.flDate = flDate;
	}

	public String getEndDes() {
		return endDes;
	}

	public void setEndDes(String endDes) {
		this.endDes = endDes;
	}

	public String getStartDes() {
		return startDes;
	}

	public void setStartDes(String startDes) {
		this.startDes = startDes;
	}

	public String getFlName() {
		return flName;
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getTotalBookedSeat() {
		return totalBookedSeat;
	}

	public void setTotalBookedSeat(int totalBookedSeat) {
		this.totalBookedSeat = totalBookedSeat;
	}

	public int getTotalAvailableSeat() {
		return totalAvailableSeat;
	}

	public void setTotalAvailableSeat(int totalAvailableSeat) {
		this.totalAvailableSeat = totalAvailableSeat;
	}

	

	public ClassPrice getClassPrice() {
		return classPrice;
	}

	public void setClassPrice(ClassPrice classPrice) {
		this.classPrice = classPrice;
	}

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