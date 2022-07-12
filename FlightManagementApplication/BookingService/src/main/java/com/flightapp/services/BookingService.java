package com.flightapp.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightapp.entity.BookingModel;
import com.flightapp.entity.BookingRecord;
import com.flightapp.entity.BookingStatus;
import com.flightapp.entity.Flight;
import com.flightapp.entity.Passenger;
import com.flightapp.exceptions.BookingException;
import com.flightapp.exceptions.BookingNotFoundException;
import com.flightapp.repositories.BookingRepository;


import com.flightapp.repositories.PassengerRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	
//	
//	public List<FlightModel> searchFlights(SearchQuery query){
//		List<FlightModel> flights = restTemplate.getForObject("http://localhost:8082/flight/search", List.class);
//		return flights;
//	}
	
	
	
	
	//http://localhost:8082/flight/
	public long bookTicket(int flightid,BookingModel model) throws BookingException {
		 BookingRecord record=new BookingRecord();
		 Flight flight=restTemplate.getForObject("http://localhost:8083/flight/"+flightid, Flight.class);
		 
			if(flight.getSeats()<(model.getPassenger().size())) {
				throw new BookingException("No seats available");
			}
			
			record.setEmail(model.getEmail());
			record.setName(model.getName());
			record.setMeal(model.getMeal());
			record.setFlightNumber(flight.getFlightNumber());
			record.setAirlineName(flight.getAirlineName());
			record.setFlightDate(flight.getArrivalTime());
			record.setSource(flight.getDepartureCity());
			record.setDestination(flight.getArrivalCity());
			record.setNoOfSeat(model.getNoOfSeat());
			record.setTotal_amount(model.getNoOfSeat()*flight.getPrice());
			List<Passenger> passengers =model.getPassenger();
		passengers.forEach(passenger -> passengerRepo.saveAndFlush(passenger));
		//passengers.forEach(passenger -> record.setPassengers(passengers));
		
		
	record.getPassengers().addAll(passengers);
//		record.setPassengers(passengers);
		record.setBookingDate(new Date());
		record.setStatus(BookingStatus.BOOKING_CONFIRMED);
		long pnr =bookingRepo.save(record).getPnr();
			return pnr;
	
		
	}
	
	
	//Getting booking details by pnr
	public BookingRecord getBooking(long pnr) throws BookingNotFoundException {
		BookingRecord records= bookingRepo.findById(pnr);
	//	List<Passenger> passengers=passengerRepo.findAll();
//		System.out.println(passengers);
	//	records.setPassengers(passengers);
		
		
		return records;
	}
	
	//Getting booking records by email id
	public List<BookingRecord> getBookingByEmail(String email) {
		return bookingRepo.findBookingsByEmail(email);
		
	}
	
	//getting all booking records-admin
	
	public List<BookingRecord> getAllBookings(){
		return bookingRepo.findAll();
		}
	
	//cancel booking
	
	
	public String cancelBookingBypnr(long pnr) {
	BookingRecord record1= bookingRepo.getById(pnr);
	
	record1.setStatus(BookingStatus.BOOKING_CANCELLED);
	//System.out.println(record1);
	bookingRepo.save(record1);
	//System.out.println(record1);
	return "Booking cancelled for pnr " + pnr;
	}
	
	
	public void deleteBookingBypnr(long pnr) {
		bookingRepo.deleteById(pnr);
	}
	
}
