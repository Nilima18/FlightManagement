package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.Airline;
import com.flightapp.services.AirlineService;

@RestController
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineServive;
	
	
	@PostMapping("/register")
	public Airline registerNewAirline(@RequestBody Airline airline) {
		return airlineServive.createAirline(airline);
		
	}
	
	@GetMapping("/")
	public List<Airline> viewAllAirline(){
		return airlineServive.getAllAirlines();
		
	}
	
	@DeleteMapping
	public void removeAirline(@PathVariable int id) {
		airlineServive.removeAirline(id);
	}
	

}
