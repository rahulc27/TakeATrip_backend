package com.project.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.BookingDTO;
import com.project.dto.DestinationDTO;
import com.project.dto.DetailsDTO;
import com.project.dto.ItineraryDTO;
import com.project.entity.Booking;
import com.project.entity.Destination;
import com.project.entity.Details;
import com.project.entity.Itinerary;
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
		
		if(destination.getAvailability() < bookingDto.getNoOfPeople()) throw new TakATripException("DestinationService.PACKAGE_NOT_SUFFICIENT");
		
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
	
	@Override
	public Set<BookingDTO> getBooking(Integer userId) throws TakATripException{
		
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new TakATripException("UserService.USER_NOT_FOUND"));
		
		Set<Booking> booking = user.getListOfBooking();
		Set<BookingDTO> bookingDtoSet = new HashSet<>();
		
		if(booking.isEmpty()) {
			throw new TakATripException("UserService.NO_BOOKING_FOUND");
		}else {
			for(Booking bookingElement : booking) {
				BookingDTO bookingDTO = new BookingDTO();
				
				bookingDTO.setBookingId(bookingElement.getBookingId()); 
				bookingDTO.setCheckIn(bookingElement.getCheckIn()); 
				bookingDTO.setCheckOut (bookingElement.getCheckOut());
				bookingDTO.setNoOfPeople(bookingElement.getNoOfPeople());
				bookingDTO.setTimeOfBooking (bookingElement.getTimeOfBooking());
				bookingDTO.setTotalCost(bookingElement.getTotalCost());
				
				DestinationDTO destinationDTO= new DestinationDTO(); 
				Destination destination =  bookingElement.getDestination();

				destinationDTO.setDestinationName(destination.getDestinationName()); 
				destinationDTO.setContinent (destination.getContinent());
				destinationDTO.setAvailability(destination.getAvailability());
				destinationDTO.setChargePerPerson(destination.getChargePerPerson()); 
				destinationDTO.setDestinationId(destination.getDestinationId());
				destinationDTO.setDiscount (destination.getDiscount()); 
				destinationDTO.setFlightCharge(destination.getFlightCharge()); 
				destinationDTO.setNoOfNights(destination.getNoOfNights()); 
				destinationDTO.setImageUrl(destination.getImageUrl());
				
				DetailsDTO detailsDto = new DetailsDTO(); 
				Details details = destination.getDetails();

				detailsDto.setAbout(details.getAbout()); 
				detailsDto.setDetailsId(details.getDetailsId());
				detailsDto.setHighlights(details.getHighlights()); 
				detailsDto.setPace(details.getAbout()); 
				detailsDto.setPackageInclusion(details.getPackageInclusion());
				
				ItineraryDTO itineraryDTO = new ItineraryDTO(); 
				Itinerary itinerary = details.getIntinerary();

				itineraryDTO.setFirstDay(itinerary.getFirstDay());
				itineraryDTO.setItineraryId(itinerary.getItineraryId());
				itineraryDTO.setLastDay (itinerary.getLastDay()); 
				itineraryDTO.setRestOfDays (itinerary.getRestOfDays());

				detailsDto.setIntineraryDTO(itineraryDTO);

				destinationDTO.setDetailsDTO(detailsDto);
				
				bookingDTO.setDestinationDTO(destinationDTO);
				
				bookingDtoSet.add(bookingDTO);
				
								
			}
		}
		
		return bookingDtoSet;
	}
	

}
