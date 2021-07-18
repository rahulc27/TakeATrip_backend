package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.DestinationDTO;
import com.project.dto.DetailsDTO;
import com.project.dto.ItineraryDTO;
import com.project.entity.Destination;
import com.project.entity.Details;
import com.project.entity.Itinerary;
import com.project.exception.TakATripException;
import com.project.repository.DestinationRepository;

@Service(value = "destinationService")
@Transactional
public class DestinationServiceImpl implements DestinationService{
	
	@Autowired
	private DestinationRepository destinationRepository;
	
	@Override
	public List<DestinationDTO> getDestinationBySearch(String continent) throws TakATripException{
		
		List<Destination> destinationList = destinationRepository.finfByContinentIgnoreCase(continent);
		
		List<DestinationDTO> destinationDtoList = new ArrayList<>();
		
		if(destinationList.isEmpty()) {
			throw new TakATripException("DestinationService.INVALID_CONTINENT");
		}else {
			
			for(Destination dest: destinationList) {
				
				DestinationDTO destinationDto = new DestinationDTO();
				
				destinationDto.setDestinationId(dest.getDestinationId());
				destinationDto.setAvailability(dest.getAvailability());
				destinationDto.setChargePerPerson(dest.getChargePerPerson());
				destinationDto.setContinent(dest.getContinent());
				destinationDto.setDestinationName(dest.getDestinationName());
				destinationDto.setDiscount(dest.getDiscount());
				destinationDto.setFlightCharge(dest.getFlightCharge());
				destinationDto.setImageUrl(dest.getImageUrl());
				destinationDto.setNoOfNights(dest.getNoOfNights());
				
				DetailsDTO detailsDto = new DetailsDTO();
				Details details = dest.getDetails();
				
				detailsDto.setDetailsId(details.getDetailsId());
				detailsDto.setAbout(details.getAbout());
				detailsDto.setHighlights(details.getHighlights());
				detailsDto.setPace(details.getAbout());
				detailsDto.setPackageInclusion(details.getPackageInclusion());
				
				ItineraryDTO itineraryDto = new ItineraryDTO();
				Itinerary itinerary = details.getIntinerary();
				
				itineraryDto.setItineraryId(itinerary.getItineraryId());
				itineraryDto.setFirstDay(itinerary.getFirstDay());
				itineraryDto.setRestOfDays(itinerary.getRestOfDays());
				itineraryDto.setLastDay(itinerary.getLastDay());
				
				detailsDto.setIntineraryDTO(itineraryDto);
				
				destinationDto.setDetailsDTO(detailsDto);
				
				destinationDtoList.add(destinationDto);
				
			}
		}
		
		return destinationDtoList;
	}
	
	@Override
	public List<DestinationDTO> getDestinationByDiscount() throws TakATripException{
		

		List<Destination> destinationList = destinationRepository.findByDiscountGreaterThanEqual(1);
		
		List<DestinationDTO> destinationDtoList = new ArrayList<>();
		
		if(destinationList.isEmpty()) {
			throw new TakATripException("DestinationService.NO_DISCOUNT");
		}else {
			
			for(Destination dest: destinationList) {
				
				DestinationDTO destinationDto = new DestinationDTO();
				
				destinationDto.setDestinationId(dest.getDestinationId());
				destinationDto.setAvailability(dest.getAvailability());
				destinationDto.setChargePerPerson(dest.getChargePerPerson());
				destinationDto.setContinent(dest.getContinent());
				destinationDto.setDestinationName(dest.getDestinationName());
				destinationDto.setDiscount(dest.getDiscount());
				destinationDto.setFlightCharge(dest.getFlightCharge());
				destinationDto.setImageUrl(dest.getImageUrl());
				destinationDto.setNoOfNights(dest.getNoOfNights());
				
				DetailsDTO detailsDto = new DetailsDTO();
				Details details = dest.getDetails();
				
				detailsDto.setDetailsId(details.getDetailsId());
				detailsDto.setAbout(details.getAbout());
				detailsDto.setHighlights(details.getHighlights());
				detailsDto.setPace(details.getAbout());
				detailsDto.setPackageInclusion(details.getPackageInclusion());
				
				ItineraryDTO itineraryDto = new ItineraryDTO();
				Itinerary itinerary = details.getIntinerary();
				
				itineraryDto.setItineraryId(itinerary.getItineraryId());
				itineraryDto.setFirstDay(itinerary.getFirstDay());
				itineraryDto.setRestOfDays(itinerary.getRestOfDays());
				itineraryDto.setLastDay(itinerary.getLastDay());
				
				detailsDto.setIntineraryDTO(itineraryDto);
				
				destinationDto.setDetailsDTO(detailsDto);
				
				destinationDtoList.add(destinationDto);
				
			}
		}
		
		return destinationDtoList;
	}
	

}
