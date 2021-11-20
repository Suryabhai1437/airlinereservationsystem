package com.ars.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Phone {
	private long phone1;	
	private long phone2;
	public Phone() {
		super();
		
	}
	public Phone(long phone1, long phone2) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	public long getPhone1() {
		return phone1;
	}
	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}
	public long getPhone2() {
		return phone2;
	}
	public void setPhone2(long phone2) {
		this.phone2 = phone2;
	}
	@Override
	public String toString() {
		return "Phone [phone1=" + phone1 + ", phone2=" + phone2 + "]";
	}	
	
	
	
}
