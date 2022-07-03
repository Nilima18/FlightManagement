package com.flightapp.entity;

public class Fare {
	
	private String flightNumber;
	private String flightDate;
	private String Fare;
	
	
	public Fare() {
		super();
	}
	public Fare(String flightNumber, String flightDate, String fare) {
		super();
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		Fare = fare;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getFare() {
		return Fare;
	}
	public void setFare(String fare) {
		Fare = fare;
	}
	@Override
	public String toString() {
		return "Fare [flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", Fare=" + Fare + "]";
	}
	
	

}
