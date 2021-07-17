package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.UserDTO;
import com.project.entity.User;
import com.project.exception.TakATripException;
import com.project.repository.UserRepository;


@Service(value = "userService")
@Transactional
public class UserServiceImpl implements  UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public String registerUser(UserDTO user) throws TakATripException{
		
		User optionalUser = userRepository.findByContactNumber(user.getContactNumber());
		
		if(optionalUser != null) {
			throw new TakATripException("UserService.CONTACT_NUMBER_ALREADY_EXISTS");
		}
		
		try {
			userRepository.save(user.userDtoToEntity());
		}
		catch (Exception e) {
			throw new TakATripException("UserService.REGISTRAION_FAILED");
		}
		
		return "UserAPI.REGISTER_USER_SUCCESS";
	}
	
	@Override
	public UserDTO checkAuth(String contactNumber, String password) throws TakATripException{
		
		User optionalUser = userRepository.findByContactNumber(contactNumber);
		
		if(optionalUser == null) {
			throw new TakATripException("UserService.INVALID_CREDENTIALS");
		}
		
		String pwdFromDB = optionalUser.getPassword();
		
		if(pwdFromDB != null) {
			if(pwdFromDB.equals(password)) {
				return optionalUser.userEntitiyToDTO();
			}
			else {
				throw new TakATripException("UserService.INVALID_CREDENTIALS");
			}
			
		}
		else {
			throw new TakATripException("UserService.INVALID_CREDENTIALS");
		}
		
	}
}
