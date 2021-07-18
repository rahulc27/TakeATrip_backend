package com.project.service;

import java.util.Set;

import com.project.dto.BookingDTO;
import com.project.exception.TakATripException;

public interface BookingService {
	
	public String bookTour(Integer userId, BookingDTO bookingDto) throws TakATripException;
	
	public Set<BookingDTO> getBooking(Integer userId) throws TakATripException;
}
