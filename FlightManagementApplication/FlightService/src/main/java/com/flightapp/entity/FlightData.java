package com.flightapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="FlightData")
public class FlightData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "this can not be blank")
	private String flightNumber;
	@NotBlank(message = "this can not be blank")
	private String airlineName;
	@NotBlank(message = "this can not be blank")
	private String arrivalCity;
	@NotBlank(message = "this can not be blank")
	private String departureCity;
	@NotBlank(message = "this can not be blank")
	private String arrivalTime;
	@NotBlank(message = "this can not be blank")
	private String departureTime;
	@NotNull
	private double price;
	@NotBlank(message = "this can not be blank")
	private String Days;
	@NotNull
	private int seats;
	@NotBlank(message = "this can not be blank")
	private String instrument;
	@NotBlank(message = "this can not be blank")
	private String meal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public FlightData(String flightNumber, String airlineName, String arrivalCity, String departureCity,
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
	public FlightData() {
		super();
	}
	@Override
	public String toString() {
		return "FlightData [id=" + id + ", flightNumber=" + flightNumber + ", airlineName=" + airlineName
				+ ", arrivalCity=" + arrivalCity + ", departureCity=" + departureCity + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", price=" + price + ", Days=" + Days + ", seats=" + seats
				+ ", instrument=" + instrument + ", meal=" + meal + "]";
	}
	
	
	
	

}
