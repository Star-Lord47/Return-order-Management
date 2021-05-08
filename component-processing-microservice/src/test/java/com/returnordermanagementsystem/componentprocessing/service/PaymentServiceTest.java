package com.returnordermanagementsystem.componentprocessing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.returnordermanagementsystem.componentprocessing.feignclient.PaymentFeignClient;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PaymentServiceTest {

	@Autowired
	PaymentService paymentService;
	@MockBean
	private PaymentFeignClient paymentFeignClient;
	
	/* 
	 * Test method to check functionality of completeProcessing()
	 * when current balance after transaction is equal to zero
	 */
	
	@Test
	void testCompleteProcessing_BalanceEqualToZero() {
		String expectedOutput = "Payment Successful.Thank you for using our Service";
		when(paymentFeignClient.getCurrentBalance(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(0.0);
		String actualOutput = paymentService.completeProcessing(1, 1234567890, 1000, 1000);
		assertEquals(expectedOutput, actualOutput);
	}

	/* 
	 * Test method to check functionality of completeProcessing()
	 * when current balance after transaction is less than zero
	 *
	 */
	
	@Test
	void testCompleteProcessing_BalanceLessThanZero() {
		String expectedOutput = "Your payment could not be processed due to Insufficient Funds.";
		when(paymentFeignClient.getCurrentBalance(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(-10.0);
		String actualOutput = paymentService.completeProcessing(1, 1234567890, 1000, 1000);
		assertEquals(expectedOutput, actualOutput);
	}

	/* 
	 * Test method to check functionality of completeProcessing()
	 * when current balance after transaction is more than zero
	 *
	 */
	
	@Test
	void testCompleteProcessing_BalanceMoreThanZero() {
		String expectedOutput = "Payment Successful.Thank you for using our Service";
		when(paymentFeignClient.getCurrentBalance(Mockito.anyLong(), Mockito.anyDouble())).thenReturn(1000.0);
		String actualOutput = paymentService.completeProcessing(1, 1234567890, 1000, 1000);
		assertEquals(expectedOutput, actualOutput);
	}
}