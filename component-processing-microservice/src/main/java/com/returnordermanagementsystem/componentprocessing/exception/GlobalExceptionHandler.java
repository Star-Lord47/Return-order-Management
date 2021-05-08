package com.returnordermanagementsystem.componentprocessing.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*
	 * Format of Exception 
	 *  "timestamp": "2021-04-28T09:17:41.779+00:00", 
	 * 	 "status": 404, 
	 *   "error": "Not Found", 
	 *   "message": "No message available", 
	 * 
	 */
	
	/*
	 * This method will be called if validation on an argument annotated with @Valid
	 * fails.
	 */
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.info("Start");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        
        // Get all validation errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

        // Add errors to the response map        
        body.put("errors", errors);

        log.info("End");
        return new ResponseEntity<>(body, headers, status);
        
    }
	
	/*
	 * This method will be called if the format of the request is Invalid
	 * example - if user id is 001 it will throw InvalidFormatException
	 *           userid should not start with 0
	 */
	   @Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status,WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", status.value());
	        body.put("error", "Bad Request");

	        if (ex.getCause() instanceof InvalidFormatException) {
	            final Throwable cause = ex.getCause() == null ? ex : ex.getCause();
	            for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) {
	                body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
	            }
	        }
	        return new ResponseEntity<>(body, headers, status);
	    }
}