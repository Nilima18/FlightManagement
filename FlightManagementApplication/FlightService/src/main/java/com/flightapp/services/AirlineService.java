package com.flightapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entity.Airline;
import com.flightapp.repositories.AirlineRepository;

@Service
public class AirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	public Airline createAirline(Airline airline) {
		return airlineRepository.save(airline);
	}
	
	public List<Airline> getAllAirlines(){
		return airlineRepository.findAll();
		}
	
	public void removeAirline(int id) {
		airlineRepository.deleteById(id);
	}
	
	public String checkStatusOfAirline() {
		Airline airline=new Airline();
		if(airline.getStatus() == "Blocked") {
			return "Airline is blocked";
		}
		return "Airline is available";
	}

}
