package com.project.api;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.dto.BookingDTO;
import com.project.service.BookingService;

@CrossOrigin
@RestController
@RequestMapping("BookingApi")
public class BookingApi {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/booking/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> bookTour(@RequestBody BookingDTO booking, @PathVariable Integer userId){
		try {
			String returnBooking = bookingService.bookTour(userId, booking);
			return new ResponseEntity<String>(returnBooking, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/getbooking/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Set<BookingDTO>> getBooking(@PathVariable Integer userId){
		try {
			Set<BookingDTO> returnBooking = bookingService.getBooking(userId);
			return new ResponseEntity<Set<BookingDTO>>(returnBooking, HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}

}
