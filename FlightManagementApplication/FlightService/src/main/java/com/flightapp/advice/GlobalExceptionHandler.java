package com.flightapp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightapp.exceptions.ErrorMessage;
import com.flightapp.exceptions.FlightNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEx(FlightNotFoundException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.NOT_FOUND);
	}
	

}
