package com.project.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class BookingDTO {

	private Integer bookingId;
	
	@NotNull(message = "check in date required.")
	@Future(message = "Make sure check in date greater than current date.")
	private LocalDate checkIn;
	
	@NotNull(message = "check out date required.")
	@Future(message = "Make sure check out date greater than current date.")
	private LocalDate checkOut;
	
	@NotNull(message = "number of people required.")
	@Min(value = 1, message = "Number of people must be greater than 0.")
	@Max(value = 5, message = "number of peoples must not be greater than 5.")
	private Integer noOfPeople;
	
	@NotNull(message = "Total cost required.")
	private float totalCost;
	
	private LocalDateTime timeOfBooking = LocalDateTime.now();
	
	@NotNull(message = "Destination Required.")
	private UserDTO userDTO;
	
	private DestinationDTO destinationDTO;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDateTime getTimeOfBooking() {
		return timeOfBooking;
	}

	public void setTimeOfBooking(LocalDateTime timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public DestinationDTO getDestinationDTO() {
		return destinationDTO;
	}

	public void setDestinationDTO(DestinationDTO destinationDTO) {
		this.destinationDTO = destinationDTO;
	}
	
	
}
