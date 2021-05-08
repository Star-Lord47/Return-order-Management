package com.returnordermanagement.paymentservice.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.returnordermanagement.paymentservice.dao.CardRepository;
import com.returnordermanagement.paymentservice.exception.CardNotFoundException;
import com.returnordermanagement.paymentservice.model.CreditCard;
import com.returnordermanagement.paymentservice.service.CardService;

@ExtendWith(MockitoExtension.class)
 class TestService {

	@Mock
	CardRepository repo;
	
	@Mock
	CreditCard card;
	
	@InjectMocks
	CardService service;
	
	@InjectMocks
	private CardService cardService;
	
	@Test
	 void testProcessPaymentPositive() {
		
		card=new CreditCard(1234567890,4000);
		when(repo.findByCardNumber(1234567L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		/*Testing for non-zero balance*/ 
		assertEquals(2000.0,service.processPayment(1234567L, 2000),0.00);
		
		
	}
	@Test 
	 void testNotNullTestServiceObject() {
		assertNotNull(cardService);
	}
	
	@Test
	 void PaymentTestForZeroBalance()  {
		
		card=new CreditCard(1234567890,5000);
		when(repo.findByCardNumber(1234567L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		/*Testing for zero balance*/
		assertEquals(0.0,service.processPayment(1234567L, 5000),0.00);
		
		
	}
	
	
	@Test
	 void testProcessPaymentNegativeNotEquals() {
		
		card=new CreditCard(1234567L,4000);
		when(repo.findByCardNumber(1234567L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		
		assertNotEquals(1000.0,cardService.processPayment(1234567L, 2000),0.00);
		assertNotEquals(1000,cardService.processPayment(1234567L, 5000),0.0);
		
		
		
	}
	
	@Test
	 void testProcessPaymentNegativeEqualsFalse() {
		
		card=new CreditCard(1234567L,4000);
		when(repo.findByCardNumber(1234567L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		double rem=1000;
		
		assertNotEquals(cardService.processPayment(1234567L, 2000),rem);
		
		
		
		
	}

	@Test
	 void testProcessPaymentPositiveNotEquals() {
		
		card=new CreditCard(1234567890,4000);
		when(repo.findByCardNumber(1234567L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		
		assertNotEquals(3000.0,service.processPayment(1234567L, 2000),0.00);
		
		
	}
	 @Test
		 void testEqualsMethod() {
			boolean equals = card.equals(card);
			assertTrue(equals);
		}
	 
	 @Test
		 void testProcessPaymentPositiveFalse() {
			
			card=new CreditCard(1234567L,4000);
			when(repo.findByCardNumber(1234567L)).thenReturn(card);
			when(repo.save(any(CreditCard.class))).thenReturn(card);
			double rem=1000;
			
			assertNotEquals(cardService.processPayment(1234567L, 2000),rem);
			
			
			
			}
	 
	 @Test
		 void testProcessPaymentPositiveTrue() {
			
			card=new CreditCard(1234567L,4000);
			when(repo.findByCardNumber(1234567L)).thenReturn(card);
			when(repo.save(any(CreditCard.class))).thenReturn(card);
			double rem=2000;
			assertEquals(cardService.processPayment(1234567L, 2000),rem);
			
			
			
			}

}
