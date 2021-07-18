package com.project.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.dto.DestinationDTO;
import com.project.exception.TakATripException;
import com.project.service.DestinationService;

@CrossOrigin
@RestController
@RequestMapping("DestinationApi")
public class DestinationApi {

	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/packages/{continent}")
	public ResponseEntity<List<DestinationDTO>> getDestinationBySearch(@PathVariable String continent) throws TakATripException{
		try {
			
			List<DestinationDTO> destList = destinationService.getDestinationBySearch(continent);
			
			ResponseEntity<List<DestinationDTO>> response = new ResponseEntity<List<DestinationDTO>>(destList, HttpStatus.OK);
			
			return response;
			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(e.getMessage()), e);
		}
	}
	
}
