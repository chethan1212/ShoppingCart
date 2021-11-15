package com.equal.experts.shopping;

/**
 * Exception thrown when the input to the shopping cart is null or empty.
 */
public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}
}
