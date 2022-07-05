package com.flightapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.entity.FlightData;
import com.flightapp.entity.SearchQuery;
import com.flightapp.exceptions.FlightNotFoundException;

import com.flightapp.services.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	
	
	@PostMapping("/airline/register")
	public Airline registerNewAirline(@RequestBody Airline airline) {
		return flightService.createAirline(airline);
		
	}
	
	@GetMapping("/airline")
	public List<Airline> viewAllAirline(){
		return flightService.getAllAirlines();
		
	}

	
	@PutMapping("/airline")
	public Airline updateAirline(@RequestBody Airline airline) {
		return flightService.updateAirlineById(airline);
	}
	
	@DeleteMapping("/airline/{id}")
	public void removeAirline(@PathVariable int id) {
		flightService.removeAirline(id);
	}
	
	
	@PostMapping("/flight/addNewFlight")
	public FlightData addNewFlight(@Valid @RequestBody FlightData flightData) {
		return flightService.addNewFlight(flightData);
	}
	
	
	@GetMapping("/flight/allFlights")
	public List<FlightData> getAllFlights(){
		return flightService.getAllFlights();
	}
	
	
	@PutMapping("/flight/updateFlight")
	public FlightData updateFlight(@Valid @RequestBody FlightData flightData) {
		return flightService.updateFlight(flightData);
	}
	
	
//	@GetMapping("/search")
//	public List<FlightData> searchFlights(@RequestBody SearchQuery query){
//		return flightService.searchFlights(query);
//	}
//	
	
	@GetMapping("/flight/search")
	public List<Flight> searchFlights(@RequestBody SearchQuery query){
		return flightService.searchFlights(query);
	}	
	
	
	@GetMapping("/flight/{id}")
	public FlightData getFlightById(@PathVariable int id) throws FlightNotFoundException {
		
		return flightService.findFlightById(id);
	}
	
	
	@DeleteMapping("/flight/{flightid}")
	public void deleteFlightByid(@PathVariable int flightid) {
		flightService.removeFlightById(flightid);
	}
	
	@GetMapping("/flight")
	public List<Flight> getFlightsByDestinationAndSource(@RequestParam("destination") String destination ,@RequestParam("source")  String source) {
		return flightService.searchFlightByOriginDestination(destination, source);
		
	}
	
//	@GetMapping("/blockedAirlines")
//	public List<Airline> getblockedAilrines(){
//		
//		return flightService.blockedAilrines();
//	}

	
	
	@ResponseStatus(code =HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleException(MethodArgumentNotValidException exception){
		Map <String,String> messages = new HashMap<>();
		exception.getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = ((FieldError)error).getDefaultMessage();
			messages.put(fieldName, errorMessage);
	});
	return messages;
	}

}
