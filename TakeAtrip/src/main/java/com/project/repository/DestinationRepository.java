package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.entity.Destination;
import com.project.exception.TakATripException;

public interface DestinationRepository extends CrudRepository<Destination, String>{
	
	@Query("select p from Destination p where p.destinationName LIKE %:continent% OR p.continent LIKE %:continent%")
	public List<Destination> finfByContinentIgnoreCase(@Param("continent") String continent) throws TakATripException;
}
