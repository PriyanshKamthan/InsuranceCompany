package com.cts.insurancecompany.exceptions;

public class InvalidClaimDetailsException extends RuntimeException {
	public InvalidClaimDetailsException(String message) {
		super(message);
	}
}
