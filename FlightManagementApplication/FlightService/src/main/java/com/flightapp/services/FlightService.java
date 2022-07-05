package com.flightapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.entity.FlightData;
import com.flightapp.entity.SearchQuery;
import com.flightapp.exceptions.FlightNotFoundException;
import com.flightapp.repositories.AirlineRepository;
import com.flightapp.repositories.FlightDataRepository;



@Service
public class FlightService {
	
	@Autowired
	private FlightDataRepository flightDataRepository;
	
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	
	public Airline createAirline(Airline airline) {
		return airlineRepository.save(airline);
	}
	
	public List<Airline> getAllAirlines(){
		return airlineRepository.findAll();
		}
	
	public Airline updateAirlineById(Airline airline) {
		return airlineRepository.save(airline);
		
	}
	
	public void removeAirline(int id) {
		airlineRepository.deleteById(id);
	}
	
	
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
	

	
	public List<Flight> searchFlightByOriginDestination(String destination,String source){
		List<Airline> blockedAirlines = airlineRepository.getBlockedAirlines();

		List<FlightData> flights= flightDataRepository.searchFlightByOriginDestination(destination, source);
		List<Flight> resultflights =new ArrayList<>();
		
		for (FlightData f: flights) {
			Flight flight = new Flight();
			flight.setId(f.getId());
			flight.setFlight_number(f.getFlightNumber());
			flight.setAirline_name(f.getAirlineName());
			flight.setArrival_city(f.getArrivalCity());
			flight.setDeparture_city(f.getDepartureCity());
			flight.setDeparture_time(f.getDepartureTime());
			flight.setPrice(f.getPrice());
			resultflights.add(flight);
			for (Airline a : blockedAirlines) {
				if(a.getAirlineName().equals(flight.getAirline_name())) {
					resultflights.remove(flight);
				}
			}
			
					}
				return resultflights;
		}


	

	public List<Flight> searchFlights(SearchQuery query) {
		List<FlightData> flights= flightDataRepository.searchFlightByOriginDestinationAndDate( query.getDestination(),query.getSource(),query.getFlightdate());
		List<Flight> resultflight =new ArrayList<>();
		
		for (FlightData f: flights) {
			Flight flight = new Flight();
			flight.setId(f.getId());
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
	
//	public List<Airline> blockedAilrines(){
//		List<Airline> blockedAirlines = airlineRepository.getBlockedAirlines();
//		return blockedAirlines;
//	}

			
			

	
	
}
