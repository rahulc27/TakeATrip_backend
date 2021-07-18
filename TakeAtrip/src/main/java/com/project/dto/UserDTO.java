package com.project.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.project.entity.User;

public class UserDTO {
	
	private Integer userId;
	
	@Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z]+)*", message = "Invalid user name Format.")
	private String userName;
	
	@NotNull(message = "Email required.")
	@Pattern(regexp = "[A-z0-9._]+@[A-z]{2,}\\.[A-z][A-z.]+", message = "Invalid email format.")
	private String emailId;
	
	@NotNull(message = "contact Number Require.")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid Contact Number Format.")
	private String contactNumber;
	
	@NotNull(message = "password required")
	@Pattern(regexp = ".*[A-Z]+.*", message = "Uppercase character required.")
	@Pattern(regexp = ".*[0-9]+.*", message = "Numeric character required.")
	@Pattern(regexp = ".*[a-z]+.*", message = "Lowwercase character required.")
	@Pattern(regexp = ".*[!@#$%^&*]+.*", message = "Special character required.")
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
