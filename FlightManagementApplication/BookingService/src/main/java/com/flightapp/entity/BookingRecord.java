package com.flightapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="booking_record")
public class BookingRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long pnr;
	private String name;
	private String email;
	private String flightNumber;
	private String airlineName;
	private String source;
	private String destination;
	private String flightDate;
	private Date bookingDate;
	private String meal;
	private int noOfSeat;
	
	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}



	private double total_amount;
	private String status;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	
	
	@OneToMany(fetch =FetchType.EAGER , cascade=CascadeType.ALL ,mappedBy="bookingRecord")
	List<Passenger> passengers = new ArrayList<>();

	public BookingRecord() {
		super();
	}

	public long getPnr() {
		return pnr;
	}

	public void setPnr(long pnr) {
		this.pnr = pnr;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	
	@Override
	public String toString() {
		return "BookingRecord [pnr=" + pnr + ", name=" + name + ", email=" + email + ", flightNumber=" + flightNumber
				+ ", airlineName=" + airlineName + ", source=" + source + ", destination=" + destination
				+ ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", meal=" + meal + ", noOfSeat="
				+ noOfSeat + ", total_amount=" + total_amount + ", status=" + status + ", passengers=" + passengers
				+ "]";
	}

	public BookingRecord(long pnr, String name, String email, String flightNumber, String airlineName, String source,
			String destination, String flightDate, Date bookingDate, String meal, int noOfSeat, double total_amount,
			String status, List<Passenger> passengers) {
		super();
		this.pnr = pnr;
		this.name = name;
		this.email = email;
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.meal = meal;
		this.noOfSeat = noOfSeat;
		this.total_amount = total_amount;
		this.status = status;
		this.passengers = passengers;
	}


	

	
	
}
