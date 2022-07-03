package com.flightapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Flight;
import com.flightapp.entity.FlightData;
import com.flightapp.entity.SearchQuery;
import com.flightapp.exceptions.FlightNotFoundException;
import com.flightapp.repositories.FlightDataRepository;



@Service
public class FlightService {
	
	@Autowired
	private FlightDataRepository flightDataRepository;
	
	
	
	
	public FlightData addNewFlight(FlightData flightdata) {
		
		return flightDataRepository.save(flightdata);
	}
	
	@Cacheable(key="#id", value="flight")
	public FlightData findFlightById(int id) throws FlightNotFoundException  {
		 Optional<FlightData> existingFlight=flightDataRepository.findById(id);
		 if(existingFlight.isEmpty()) {
			 throw new FlightNotFoundException("Flight with flight id:" + id + " Not available ");
		 }

		
		 FlightData flight = existingFlight.get();
		 return flight;
	}
	
	public List<FlightData> getAllFlights(){
		return flightDataRepository.findAll();
	}
	
	public void removeFlightById(int flightid) {
		flightDataRepository.deleteById(flightid);
	}
	
	public FlightData updateFlight(FlightData flightData) {
		return flightDataRepository.save(flightData);
	}
	
	
//	public List<FlightData> searchFlights(SearchQuery query){
//		List<FlightData> flights= flightDataRepository.searchFlightByOriginDestinationAndDate( query.getDestination(),query.getSource(),query.getFlightdate());
//		List<Flight> flight= new ArrayList<>();
//		
//		return flights;
//	}
	
	
	
	
	public List<Flight> searchFlights(SearchQuery query){
		List<FlightData> flights= flightDataRepository.searchFlightByOriginDestinationAndDate( query.getDestination(),query.getSource(),query.getFlightdate());
		List<Flight> resultflight =new ArrayList<>();
		Flight flight = new Flight();
		for (FlightData f: flights) {
			flight.setFlight_number(f.getFlightNumber());
			flight.setAirline_name(f.getAirlineName());
			flight.setArrival_city(f.getArrivalCity());
			flight.setDeparture_city(f.getDepartureCity());
			flight.setDeparture_time(f.getDepartureTime());
			flight.setPrice(f.getPrice());
			resultflight.add(flight);
			
		}   
		
		return resultflight;
	}

}
