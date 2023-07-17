package com.cts.insurancecompany.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.insurancecompany.Message;

@RestControllerAdvice
public class InsuranceExceptionHandler {
	
	@ExceptionHandler(InvalidClaimDetailsException.class)
	public ResponseEntity<Message> invalidPolicyExceptionHandler(InvalidClaimDetailsException e) {
		String message = e.getMessage();
		return new ResponseEntity<Message>(new Message(message), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidPolicyException.class)
	public ResponseEntity<Message> invalidPolicyExceptionHandler(InvalidPolicyException e) {
		Message message = new Message(e.getMessage());
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidSurveyorException.class)
	public ResponseEntity<Message> invalidSurveyorExceptionHandler(InvalidSurveyorException e) {
		Message message = new Message(e.getMessage());
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MaximumClaimLimitReachedException.class) 
	public ResponseEntity<Message> maximumClaimLimitReachedExceptionHandler(MaximumClaimLimitReachedException e) {
		Message message = new Message(e.getMessage());
		return new ResponseEntity<Message>(message, HttpStatus.NOT_ACCEPTABLE);
	}
}
