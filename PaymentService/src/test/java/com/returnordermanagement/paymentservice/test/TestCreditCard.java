package com.returnordermanagement.paymentservice.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.returnordermanagement.paymentservice.model.CreditCard;

 class TestCreditCard {
	 
	 /*Testing CrediCard getters and setters*/
	CreditCard card = new CreditCard();
	long c=1234567;
    
	  @Test
	    void testSetCreditCardEqualCno() {
	       
	      card.setCardNumber(c);
	      assertEquals(card.getCardNumber(),c);
	       
	  }
	  
	  @Test
	    void testSetCreditCardEqualClimit() {
	       
	      
		  double p=50000;
	       card.setCardLimit(p);
	       
	       assertEquals(card.getCardLimit(),p);
	  }
	  @Test
	    void testSetCreditCardTrue() {
	       double b=9090.0;
	       card.setCardLimit(b);
	       assertEquals(card.getCardLimit(),b);
	  }
	  
	  @Test
	   void testSetCreditCardNotEquals() {
	       double b=9090.0;
	       double b1=9091.0;
	       card.setCardLimit(b);
	       assertNotEquals(card.getCardLimit(),b1);
	  }
	  
	  
	  @Test
	   void testSetCreditCardLimitNotEquals() {
	       
	      
		  double p=50000;
		  double p1=51000;
	       card.setCardLimit(p);
	       
	       assertNotEquals(card.getCardLimit(),p1);
	  }
	  
	  @Test
	    void testSetCreditCardNotEqualCLimit() {
	       
	       double b=9090.0;
	       double b1=9000.0;
	      card.setCardLimit(b);
	      assertNotEquals(b1,card.getCardLimit());
	  }
	  @Test
	    void testSetCreditCardNotEqualCNo() {
	       long d=1234568;
	       long d1=1234567;
	       card.setCardNumber(d);
	       assertNotEquals(d1,card.getCardNumber());
	       
	  }
	       
	  @Test
		 void testCreditCardConstructor() {

			CreditCard component = new CreditCard(1234569, 15000.0);
			assertEquals(1234569, component.getCardNumber());
		}
	  @Test
		 void testCreditLimitConstructor() {

			CreditCard component = new CreditCard(1234569, 60000.0);
			assertEquals(60000.0, component.getCardLimit());
		}
	  
	  @Test
		 void testEqualsMethod() {
			boolean equals = card.equals(card);
			assertTrue(equals);
		}


	  
	  @Test 
		 void testNotCreditCardObject() {
			assertNotNull(card);
		}
	  

}
