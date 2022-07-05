package com.flightapp.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="airline")
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String airlineName;
	private String contact;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Airline( String airlineName, String contact, String status) {
		super();
		
		this.airlineName = airlineName;
		this.contact = contact;
		this.status = status;
	}
	public Airline() {
		super();
	}
	@Override
	public String toString() {
		return "Airline [id=" + id + ", airlineName=" + airlineName + ", contact=" + contact + ", status=" + status
				+ "]";
	}
	
	

}
