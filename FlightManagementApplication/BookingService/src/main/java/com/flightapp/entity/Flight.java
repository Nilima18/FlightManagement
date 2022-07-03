package com.flightapp.entity;




public class Flight {
	
	private String flightNumber;
	private String airlineName;
	private String arrivalCity;
	private String departureCity;
	private String arrivalTime;
	private String departureTime;
	private double price;
	private String Days;
	private int seats;
	private String instrument;
	private String meal;
	
	
	public Flight() {
		super();
	}


	
	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDays() {
		return Days;
	}


	public void setDays(String days) {
		Days = days;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public String getInstrument() {
		return instrument;
	}


	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}


	public String getMeal() {
		return meal;
	}


	public void setMeal(String meal) {
		this.meal = meal;
	}


	public Flight( String flightNumber, String airlineName, String arrivalCity, String departureCity,
			String arrivalTime, String departureTime, double price, String days, int seats, String instrument,
			String meal) {
		super();
		
		this.flightNumber = flightNumber;
		this.airlineName = airlineName;
		this.arrivalCity = arrivalCity;
		this.departureCity = departureCity;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.price = price;
		Days = days;
		this.seats = seats;
		this.instrument = instrument;
		this.meal = meal;
	}


	

}
