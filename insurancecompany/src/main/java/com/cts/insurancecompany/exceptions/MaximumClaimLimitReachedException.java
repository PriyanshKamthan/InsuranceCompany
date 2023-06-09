package com.cts.insurancecompany.exceptions;

public class MaximumClaimLimitReachedException extends RuntimeException {
	public MaximumClaimLimitReachedException(String message) {
		super(message);
	}
}
