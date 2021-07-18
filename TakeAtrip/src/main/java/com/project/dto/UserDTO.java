package com.project.dto;

import java.util.Set;

import com.project.entity.User;

public class UserDTO {
	
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	private Set<BookingDTO> bookingList;
	
	
	public Set<BookingDTO> getBookingList() {
		return bookingList;
	}
	public void setBookingList(Set<BookingDTO> bookingList) {
		this.bookingList = bookingList;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User userDtoToEntity() {
		User user = new User();
		
		
		user.setContactNumber(this.contactNumber);
		user.setEmailId(this.emailId);
		user.setPassword(this.password);
		user.setUserName(this.userName);
		
		
		return user;
	}

}
