package com.project.dto;



public class DestinationDTO {

	private String destinationId;
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
	
	private DetailsDTO detailsDTO;

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

	public DetailsDTO getDetailsDTO() {
		return detailsDTO;
	}

	public void setDetailsDTO(DetailsDTO detailsDTO) {
		this.detailsDTO = detailsDTO;
	}
	
	
	
	}

