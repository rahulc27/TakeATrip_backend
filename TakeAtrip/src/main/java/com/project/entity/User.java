package com.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.dto.UserDTO;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Set<Booking> listOfBooking;
	
	public Integer getUserId() {
		return userId;
	}
	public Set<Booking> getListOfBooking() {
		return listOfBooking;
	}
	public void setListOfBooking(Set<Booking> listOfBooking) {
		this.listOfBooking = listOfBooking;
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
	
	public UserDTO userEntitiyToDTO() {
		
		UserDTO user = new UserDTO();
		
		user.setContactNumber(this.contactNumber);
		user.setEmailId(this.emailId);
		user.setPassword(this.password);
		user.setUserName(this.userName);
		user.setUserId(this.userId);
		
		return user;
	}
}
