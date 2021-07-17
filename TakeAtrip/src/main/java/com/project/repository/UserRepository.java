package com.project.repository;


import org.springframework.data.repository.CrudRepository;
import com.project.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByContactNumber(String contactNumber);
}
