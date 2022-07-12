package com.flightapp.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.flightapp.entity.BookingRecord;

@Repository
public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
	@Query(value="SELECT * FROM booking_record b WHERE"
			+ " b.email =:email" , nativeQuery = true)
	List<BookingRecord> findBookingsByEmail(@Param ("email") String email);

	
	@Query(value="SELECT * FROM booking_record b WHERE"
			+ " b.pnr =:pnr" , nativeQuery = true)
	BookingRecord findById(@Param ("pnr")long pnr);

}
