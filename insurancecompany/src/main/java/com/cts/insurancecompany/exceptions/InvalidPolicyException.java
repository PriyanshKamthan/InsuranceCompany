package com.cts.insurancecompany.exceptions;

public class InvalidPolicyException extends RuntimeException {
	public InvalidPolicyException(String message) {
        super(message);
    }
}
