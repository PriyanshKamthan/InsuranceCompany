package com.cts.insurancecompany.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InsuranceExceptionHandler {
	
	@ExceptionHandler(InvalidClaimDetailsException.class)
	public ResponseEntity<String> invalidPolicyExceptionHandler(InvalidClaimDetailsException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidPolicyException.class)
	public ResponseEntity<String> invalidPolicyExceptionHandler(InvalidPolicyException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidSurveyorException.class)
	public ResponseEntity<String> invalidSurveyorExceptionHandler(InvalidSurveyorException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MaximumClaimLimitReachedException.class) 
	public ResponseEntity<String> maximumClaimLimitReachedExceptionHandler(MaximumClaimLimitReachedException e) {
		String message = e.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_ACCEPTABLE);
	}
}
