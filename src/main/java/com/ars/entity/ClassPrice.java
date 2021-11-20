package com.ars.entity;

import javax.persistence.Embeddable;

@Embeddable
/**
 * 
 * @author "Vinaya Rekha Parimi"
 * @version "1.0"
 * @category Entity
 * @usage ClassPrice entity provides pricing information w.r.t Seat class i.e., Business/Economy
 * 
 */
public class ClassPrice {

	private float businessClassCost;
	private float economyClassCost;

	public ClassPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * 
 * @param businessClassCost
 * @param economyClassCost
 * @description constructor method for class price entity
 */
	public ClassPrice(float businessClassCost, float economyClassCost) {
		super();
		this.businessClassCost = businessClassCost;
		this.economyClassCost = economyClassCost;
	}
/**
 * 
 * @return economyClasscost
 * @description method to retrieve economy class cost 
 */
	public float getEconomyClassCost() {
		return economyClassCost;
	}
/**
 * 
 * @param economyClassCost
 * @description method to set economy class cost
 */
	public void setEconomyClassCost(float economyClassCost) {
		this.economyClassCost = economyClassCost;
	}
/**
 * 
 * @return businessClassCost
 * @description method to get Business class cost
 */
	public float getBusinessClassCost() {
		return businessClassCost;
	}
/**
 * 
 * @param businessClassCost
 * @description method to set Business class cost
 */
	public void setBusinessClassCost(float businessClassCost) {
		this.businessClassCost = businessClassCost;
	}

	/**
	 *
	 * @return ClassPrice Array
	 * @description method to retrieve classprice entity data
	 */
	@Override
	public String toString() {
		return "ClassPrice [businessClassCost=" + businessClassCost + ", economyClassCost=" + economyClassCost + "]";
	}

}
