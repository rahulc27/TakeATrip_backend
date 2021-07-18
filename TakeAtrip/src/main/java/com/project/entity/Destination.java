package com.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINATION")
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String destinationId;
	@Column(name = "CONTINENT")
	private String continent;
	private String destinationName;
	private String imageUrl;
	private float flightCharge;
	private float chargePerPerson;
	private float discount;
	private int noOfNights;
	
	public int getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}

	private int availability;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DETAILS_ID")
	private Details details;

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getFlightCharge() {
		return flightCharge;
	}

	public void setFlightCharge(float flightCharge) {
		this.flightCharge = flightCharge;
	}

	public float getChargePerPerson() {
		return chargePerPerson;
	}

	public void setChargePerPerson(float chargePerPerson) {
		this.chargePerPerson = chargePerPerson;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Destination [destinationId=" + destinationId + ", continent=" + continent + ", destinationName="
				+ destinationName + ", imageUrl=" + imageUrl + ", flightCharge=" + flightCharge + ", chargePerPerson="
				+ chargePerPerson + ", discount=" + discount + ", availability=" + availability + "]";
	}
	
	
}
