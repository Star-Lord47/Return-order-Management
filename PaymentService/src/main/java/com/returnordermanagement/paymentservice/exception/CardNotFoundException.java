package com.returnordermanagement.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Card not found")
public class CardNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
     public CardNotFoundException(String msg) {
		super(msg);
	}

}
