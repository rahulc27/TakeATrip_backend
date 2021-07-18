package com.project.service;

import com.project.dto.BookingDTO;
import com.project.exception.TakATripException;

public interface BookingService {
	
	public String bookTour(Integer userId, BookingDTO bookingDto) throws TakATripException;
}
