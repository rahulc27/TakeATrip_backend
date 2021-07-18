package com.project.service;

import java.util.List;

import com.project.dto.DestinationDTO;
import com.project.exception.TakATripException;

public interface DestinationService {
	
	public List<DestinationDTO> getDestinationBySearch(String continent) throws TakATripException;
	
	public List<DestinationDTO> getDestinationByDiscount() throws TakATripException;
	
}
