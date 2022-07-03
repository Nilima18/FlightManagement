package com.flightapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightapp.entity.Airline;
import com.flightapp.repositories.AirlineRepository;
import com.flightapp.services.AirlineService;

@SpringBootTest
public class TestFlight {
	
	
	@Mock
	private AirlineRepository airlineRepo;
	
	@InjectMocks
	private AirlineService createairlineService;
	
	@Test
	public void testRegisterAirline() {
		
		Airline airline = new Airline();
		airline.setAirlineName("Indigo");
		
		when(airlineRepo.save(ArgumentMatchers.any(Airline.class))).thenReturn(airline);
		
		Airline created=createairlineService.createAirline(airline);
		assertThat(created.getAirlineName()).isSameAs(airline.getAirlineName());
		verify(airlineRepo).save(airline);
		
	}
	

}
