package com.flightapp.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
	
	@Query(value="SELECT * FROM passenger p WHERE"
			+ " p.booking_record_pnr =:pnr" , nativeQuery = true)
	List<Passenger> findPassengersByPnr(@Param ("pnr") long pnr);

}
