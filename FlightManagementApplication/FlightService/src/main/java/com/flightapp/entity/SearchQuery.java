package com.flightapp.entity;

public class SearchQuery {
	String source;
	String destination;
	String flightdate;
	
	public SearchQuery() {
		super();
	}
	public SearchQuery(String source, String destination, String flightdate) {
		super();
		this.source = source;
		this.destination = destination;
		this.flightdate = flightdate;
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
	public String getFlightdate() {
		return flightdate;
	}
	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}
	@Override
	public String toString() {
		return "SearchQuery [source=" + source + ", destination=" + destination + ", flightdate=" + flightdate + "]";
	}
	

}
