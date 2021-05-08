package com.returnordermanagement.paymentservice.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.returnordermanagement.paymentservice.exception.Errormsg;



 class TestErrormsg {
    Errormsg error = new Errormsg();
    
    /*Testing Error message creation*/
	  @Test
	   void SetTestError() {
	      
	       
	       String msg="Card not found";
	       error.setMessage(msg);
	       assertSame(error.getMessage(),msg);
	      

}
	  @Test
	    void GetTestError() {
		 
		  String msg="Card not found";
		  error.setMessage(msg);
	      assertSame(error.getMessage(),msg);
	      

}
	  @Test 
		 void testNotNullErrormsgObject() {
			assertNotNull(error);
		}
	  
	  @Test
		 void testEqualsMethod() {
			boolean equals = error.equals(error);
			assertTrue(equals);
		}
	  
	  @Test
	   void GetTestErrorFalse() {
		  
		  String msg="Card not found";
		  error.setMessage(msg);
		  String msg1="Card found";
	       /*Passing wrong message*/
	      assertNotSame(error.getMessage(),msg1);
	      

}
	  
	  @Test
	   void GetTestErrorEquals() {
		  
		  String msg="Card not found";
		  error.setMessage(msg);
	      assertEquals(msg,error.getMessage());
	      

}
	  
	  @Test
	   void GetTestErrorNotEquals() {
		 
		  String msg="Card not found";
		  error.setMessage(msg);
		  String msg1="Card found";
	      assertNotEquals(msg1,error.getMessage());
	      

}
}
