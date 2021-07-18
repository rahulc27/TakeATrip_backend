package com.project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.BookingDTO;
import com.project.entity.Booking;
import com.project.entity.Destination;
import com.project.entity.User;
import com.project.exception.TakATripException;
import com.project.repository.BookingRepository;
import com.project.repository.DestinationRepository;
import com.project.repository.UserRepository;

@Service(value = "bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private DestinationRepository destinatinRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public String bookTour(Integer userId, BookingDTO bookingDto) throws TakATripException{
		
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new TakATripException("UserService.USER_NOT_FOUND"));
		
		Booking booking = new Booking();
		
		Optional<Destination> optionalDestination = destinatinRepository.findById(bookingDto.getDestinationDTO().getDestinationId());
		Destination destination = optionalDestination.orElseThrow(() -> new TakATripException("DestinationService.NOT_FOUND"));
		
		if(destination.getAvailability() == 0) throw new TakATripException("DestinationService.PACKAGE_FULL");
		
		if(destination.getAvailability() < bookingDto.getNoOfPeople()) throw new TakATripException("EstinationService.PACKAGE_NOT_SUFFICIENT");
		
		destination.setAvailability(destination.getAvailability() - bookingDto.getNoOfPeople());
		
		booking.setCheckIn(bookingDto.getCheckIn());
		booking.setCheckOut(bookingDto.getCheckOut());
		booking.setNoOfPeople(bookingDto.getNoOfPeople());
		booking.setTimeOfBooking(bookingDto.getTimeOfBooking());
		booking.setDestination(destination);
		booking.setTotalCost(bookingDto.getTotalCost());
		booking.setUser(user);
		
		Booking b = bookingRepository.save(booking);
		
		
		
		return "Booking successful with the Booking ID : " + b.getBookingId();
	}
	
	
//	bookingDTO.setBookingId(bookingElement.getBookingId()); 
//	bookingDTO.setCheckIn(bookingElement.getCheckIn()); 
//	bookingDTO.setCheckOut (bookingElement.getCheckOut());
//	bookingDTO.setNoOfPeople(bookingElement.getlioOfPeople());
//	bookingDTO.setTimeOfBooking (bookingElement.getTimeOfBooking());
//	bookingDTO.setTotalCost(bookingElement.getTotalCost());
}
