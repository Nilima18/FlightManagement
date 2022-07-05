package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer>{
	
	
	@Query(value ="select * from airline a where a.status like '%Blocked%'" , nativeQuery = true)
	List<Airline> getBlockedAirlines();

}
