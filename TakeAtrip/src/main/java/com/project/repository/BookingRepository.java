package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{

}
