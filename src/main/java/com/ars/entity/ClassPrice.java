package com.ars.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ClassPrice {

	private float businessClassCost;
	private float economyClassCost;

	public ClassPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassPrice(float businessClassCost, float economyClassCost) {
		super();
		this.businessClassCost = businessClassCost;
		this.economyClassCost = economyClassCost;
	}

	public float getEconomyClassCost() {
		return economyClassCost;
	}

	public void setEconomyClassCost(float economyClassCost) {
		this.economyClassCost = economyClassCost;
	}

	public float getBusinessClassCost() {
		return businessClassCost;
	}

	public void setBusinessClassCost(float businessClassCost) {
		this.businessClassCost = businessClassCost;
	}

	@Override
	public String toString() {
		return "ClassPrice [businessClassCost=" + businessClassCost + ", economyClassCost=" + economyClassCost + "]";
	}

}
