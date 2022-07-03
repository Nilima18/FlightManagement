package com.flightapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.Flight;
import com.flightapp.entity.FlightData;


@Repository
public interface FlightDataRepository extends JpaRepository<FlightData, Integer>{
	
//	@Query(value ="select * from flight_data f where "
//			+ "f.arrival_city = :destination and "
//			+ "f.departure_city =:source and "
//			+ "f.departure_time =:flightdate", nativeQuery = true)
//	List<FlightData> searchFlightByOriginDestinationAndDate(@Param("destination") String destination ,
//			@Param("source") String source,
//			@Param("flightdate") String flightdate);

	@Query(value ="select * "
			+ "from flight_data f where "
			+ "f.arrival_city = :destination and "
			+ "f.departure_city =:source and "
			+ "f.departure_time =:flightdate", nativeQuery = true)
	List<FlightData> searchFlightByOriginDestinationAndDate(@Param("destination") String destination ,
			@Param("source") String source,
			@Param("flightdate") String flightdate);

//	@Query(value ="select * "
//			+ "from flight_data f where "
//			+ "f.arrival_city = :destination and "
//			+ "f.departure_city =:source and "
//			+ "f.departure_time =:flightdate", nativeQuery = true)
//	List<FlightData> searchFlightByOriginDestinationAndDate(@Param("destination") String destination ,
//			@Param("source") String source,
//			@Param("flightdate") String flightdate);
}
