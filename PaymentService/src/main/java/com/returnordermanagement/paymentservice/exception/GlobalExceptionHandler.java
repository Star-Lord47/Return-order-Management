package com.returnordermanagement.paymentservice.exception;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger lOG = Logger.getLogger("com.returnordermanagement.paymentService");
	 @ExceptionHandler(Exception.class)
	    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	       Errormsg error = new Errormsg("Card not found");
	        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR); 
	    }
	 @ExceptionHandler(CardNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(CardNotFoundException ex, WebRequest request) {
	        lOG.info("In Exception");
	        Errormsg error = new Errormsg("server error");
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }
	 
	   
}

