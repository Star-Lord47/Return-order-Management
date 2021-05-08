package com.returnordermanagement.paymentservice.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.returnordermanagement.paymentservice.controller.CardController;
import com.returnordermanagement.paymentservice.service.CardService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CardController.class)
 class TestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CardService cardService;
	
	@Test
	 void testGetCallPositive() throws Exception {
		when(cardService.processPayment(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(20000.0);
		long cardnumber=1234567890;
		Double amt=50000.0;
		
		mockMvc.perform(get("/card/{cardNumber}/{charge}",cardnumber,amt)).andExpect(status().isOk());
		/*For checking the server ok status */
		
		
	}
	
	@Test
	 void testGetCallNegative() throws Exception {
		when(cardService.processPayment(Mockito.anyLong(), Mockito.anyDouble())).thenThrow(new IllegalArgumentException("in test Call"));
		long cardnumber=1234567890;
		Double amt=50000.0;
		mockMvc.perform(get("/card/{cardNumber}/{charge}",cardnumber,amt)).andExpect(status().isInternalServerError());
		/*For checking the Internal server error status */
	}
	@Test 
	 void testNotNullControllerObject() {
		assertNotNull(cardService);
	}
	
	
	
}
