package com.flightapp.entity;

public class FlightModel {
	 String flight_number;
	 String arrival_city;
	 String airline_name;
	 String departure_city;
	 String departure_time;
	 double price;
	 
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FlightModel(String flight_number, String arrival_city, String airline_name, String departure_city,
			String departure_time, double price) {
		super();
		this.flight_number = flight_number;
		this.arrival_city = arrival_city;
		this.airline_name = airline_name;
		this.departure_city = departure_city;
		this.departure_time = departure_time;
		this.price = price;
	}
	public FlightModel() {
		super();
	}
	@Override
	public String toString() {
		return "FlightModel [flight_number=" + flight_number + ", arrival_city=" + arrival_city + ", airline_name="
				+ airline_name + ", departure_city=" + departure_city + ", departure_time=" + departure_time
				+ ", price=" + price + "]";
	}
	
	
	

}
