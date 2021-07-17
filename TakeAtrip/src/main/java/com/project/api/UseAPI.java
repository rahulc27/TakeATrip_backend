package com.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.dto.UserDTO;
import com.project.exception.TakATripException;
import com.project.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("UserAPI")
public class UseAPI {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody UserDTO user) throws TakATripException{
		try {
			
			String message = userService.registerUser(user);
			return new ResponseEntity<String>(environment.getProperty(message), HttpStatus.CREATED);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> authenticateUser(@RequestBody UserDTO user){
		try {
			
			UserDTO userFromDB = userService.checkAuth(user.getContactNumber(), user.getPassword());
			return new ResponseEntity<UserDTO>(userFromDB,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}

}
