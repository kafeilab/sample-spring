/*
 * ----------------------------------------------------------------------------
 * Generic Exception handling methods should be in class annotated with
 * @ControllerAdvice
 * ----------------------------------------------------------------------------
 */
package edu.sample.spring.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.sample.spring.mvc.exception.ReservationNotAvailableException;

@ControllerAdvice
public class ExceptionHandlingAdvice {
	
	@ExceptionHandler(ReservationNotAvailableException.class)
	public String handle(ReservationNotAvailableException e) {
		return "reservationNotAvailable";
	}
	
	@ExceptionHandler
	public String handleDefault(Exception e) {
		return "error";
	}

}
