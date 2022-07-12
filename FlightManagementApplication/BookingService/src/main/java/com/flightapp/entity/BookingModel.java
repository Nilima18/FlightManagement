package com.flightapp.entity;

import java.util.ArrayList;
import java.util.List;

public class BookingModel {
	
	private String name;
	private String email;
	private int noOfSeat;
	List<Passenger> passenger = new ArrayList<>();
	private String meal;
	
	
	
	public BookingModel(String name, String email, int noOfSeat, List<Passenger> passenger, String meal) {
		super();
		this.name = name;
		this.email = email;
		this.noOfSeat = noOfSeat;
		this.passenger = passenger;
		this.meal = meal;
	}
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public BookingModel() {
		super();
	}
	@Override
	public String toString() {
		return "BookingModel [name=" + name + ", email=" + email + ", noOfSeat=" + noOfSeat + ", passenger=" + passenger
				+ ", meal=" + meal + "]";
	}
	
}
