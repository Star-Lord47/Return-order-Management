package com.returnordermanagement.packaginganddelivery.exception;

public class TokenInvalidException extends Exception {

private static final long serialVersionUID = 1L;
	
	public TokenInvalidException() {
		super();
	}

	public TokenInvalidException(String ErrorMessage) {
		super(ErrorMessage);
	}
}

