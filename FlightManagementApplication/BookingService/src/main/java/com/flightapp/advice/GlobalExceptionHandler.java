package com.flightapp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightapp.exceptions.BookingException;
import com.flightapp.exceptions.BookingNotFoundException;
import com.flightapp.exceptions.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleEx(BookingNotFoundException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorMessage> handleEx(BookingException e){
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						e.getMessage(), 
						LocalDateTime.now(), 
						e.getClass().toString())
				, HttpStatus.NOT_FOUND);
	}

}
