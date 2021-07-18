package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITINERARY")
public class Itinerary {

	@Id
	private String itineraryId;
	private String firstDay;
	private String restOfDays;
	private String lastDay;
	
	public String getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}
	public String getFirstDay() {
		return firstDay;
	}
	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}
	public String getRestOfDays() {
		return restOfDays;
	}
	public void setRestOfDays(String restOfDays) {
		this.restOfDays = restOfDays;
	}
	public String getLastDay() {
		return lastDay;
	}
	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", firstDay=" + firstDay + ", restOfDays=" + restOfDays
				+ ", lastDay=" + lastDay + "]";
	}
	
	
	
}
