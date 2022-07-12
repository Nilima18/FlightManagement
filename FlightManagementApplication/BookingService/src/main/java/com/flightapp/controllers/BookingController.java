package com.flightapp.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entity.BookingModel;
import com.flightapp.entity.BookingRecord;
import com.flightapp.entity.FlightModel;
import com.flightapp.entity.SearchQuery;
import com.flightapp.exceptions.BookingException;
import com.flightapp.exceptions.BookingNotFoundException;
import com.flightapp.services.BookingService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@GetMapping("/search")
//	public ResponseEntity<List<FlightModel>> searchFlights(@RequestBody SearchQuery query){
//	
//	ResponseEntity<List<FlightModel>> searchFlights = 
//			restTemplate.exchange("http://localhost:8082/flight/search", HttpMethod.GET, HttpEntity.EMPTY,new ParameterizedTypeReference<List<FlightModel>>(){
//			});
//	return ResponseEntity.status(HttpStatus.OK).body(searchFlights.getBody());
//	}
//	
	
	
	//ticket booking
	@PostMapping("/{flightid}")
	public long newBooking(@RequestBody BookingModel model, @PathVariable int flightid) throws BookingException {
		return bookingService.bookTicket(flightid, model);
	}
	
	@GetMapping("/{pnr}")
	public BookingRecord getBooking(@PathVariable long pnr) throws BookingNotFoundException {
		return bookingService.getBooking(pnr);
	}
	
	@GetMapping("/viewHistory")
	public List<BookingRecord> getBookingByEmail(@RequestParam ("email") String email) {
		return bookingService.getBookingByEmail(email);
		
	}
	
	@GetMapping("/all")
	public List<BookingRecord> getAllBookingRecords(){
		return bookingService.getAllBookings();
		}
	
//	@DeleteMapping("/cancel/{pnr}")
//	public void cancelBooking(@PathVariable long pnr) {
//		 bookingService.deleteBookingBypnr(pnr);
//	}
//	
	@PutMapping("/cancel/{pnr}")
	public String cancelBookingBypnr(@PathVariable long pnr) {
		
	return bookingService.cancelBookingBypnr( pnr);
	}
	
//	@GetMapping("/{flightId}")
//	public Flight getFlightById(@PathVariable int flightId ) {
//		 Flight flight=restTemplate.getForObject("http://localhost:8082/flight/"+flightId, Flight.class);
//		 return flight;
//	}
}
