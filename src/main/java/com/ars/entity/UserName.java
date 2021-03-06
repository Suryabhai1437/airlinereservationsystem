package com.ars.entity;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@Embeddable

public class UserName {

	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
