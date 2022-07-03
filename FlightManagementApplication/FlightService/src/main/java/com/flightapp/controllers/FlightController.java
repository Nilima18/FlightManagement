package com.flightapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

import com.flightapp.entity.Flight;
import com.flightapp.entity.FlightData;
import com.flightapp.entity.SearchQuery;
import com.flightapp.exceptions.FlightNotFoundException;
import com.flightapp.services.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	
	@PostMapping
	public FlightData addNewFlight(@Valid @RequestBody FlightData flightData) {
		return flightService.addNewFlight(flightData);
	}
	
	
	@GetMapping("/allFlights")
	public List<FlightData> getAllFlights(){
		return flightService.getAllFlights();
	}
	
	
	@PutMapping("/updateFlight")
	public FlightData updateFlight(@Valid @RequestBody FlightData flightData) {
		return flightService.updateFlight(flightData);
	}
	
	
//	@GetMapping("/search")
//	public List<FlightData> searchFlights(@RequestBody SearchQuery query){
//		return flightService.searchFlights(query);
//	}
//	
	
	@GetMapping("/search")
	public List<Flight> searchFlights(@RequestBody SearchQuery query){
		return flightService.searchFlights(query);
	}	
	
	
	@GetMapping("/{id}")
	public FlightData getFlightById(@PathVariable int id) throws FlightNotFoundException {
		
		return flightService.findFlightById(id);
	}
	
	
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
