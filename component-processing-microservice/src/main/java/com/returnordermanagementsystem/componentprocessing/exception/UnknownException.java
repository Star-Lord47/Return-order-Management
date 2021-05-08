package com.returnordermanagementsystem.componentprocessing.exception;

/*
 * Handles any Exception Occured at other microservice
 * 
 */
public class UnknownException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnknownException(String message) {
		super(message);
	}
}
