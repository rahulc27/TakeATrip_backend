package com.project.service;

import com.project.dto.UserDTO;
import com.project.exception.TakATripException;

public interface UserService {
	
	public UserDTO checkAuth(String contactNumber, String password) throws TakATripException;

	public String registerUser(UserDTO user) throws TakATripException;
}
