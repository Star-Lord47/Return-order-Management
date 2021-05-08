package com.returnordermanagementsystem.componentprocessing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.returnordermanagementsystem.componentprocessing.exception.InvalidTokenException;
import com.returnordermanagementsystem.componentprocessing.feignclient.AuthenticationFeignClient;
import com.returnordermanagementsystem.componentprocessing.model.AuthenticationResponse;
import com.returnordermanagementsystem.componentprocessing.model.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.model.ProcessResponse;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessRequestRepository;
import com.returnordermanagementsystem.componentprocessing.service.AccessoryPartService;
import com.returnordermanagementsystem.componentprocessing.service.IntegralPartService;
import com.returnordermanagementsystem.componentprocessing.service.PaymentService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ComponentProcessingControllerTest {

	@MockBean
	private IntegralPartService integralPartService;
	
	@MockBean
	private AccessoryPartService accessoryPartService;
	
	@MockBean
	private PaymentService paymentService;
	
	@MockBean
	private ProcessRequestRepository processRequestRepository;
	
	@MockBean
	private AuthenticationFeignClient authenticationFeignClient;
	
	@Autowired
	private ComponentProcessingController componentProcessingController;
	
	/* 
	 * Test method to check functionality of getProcessingDetails()
	 * when jwt token is invalid
	 */
	
	@Test
	void testGetProcessingDetails_UnAuthenticated()
	{
		ProcessRequest processRequest = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				true);
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",false));
		AuthenticationResponse auth=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(auth);
		assertThrows(InvalidTokenException.class, ()->componentProcessingController.getProcessingDetails("wevfhqwfvehfv68", processRequest));
	}
	
	/* 
	 * Test method to check functionality of getProcessingDetails()
	 * when jwt token is valid and component Type is Integral and request is Priority
	 */
	@Test
	void testGetProcessingDetails_Authenticated_And_Integral_Priority() throws InvalidTokenException 
	{
		ProcessRequest processRequest = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				true);
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",true));
		AuthenticationResponse authenticationResponse1=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(authenticationResponse1);
		ProcessResponse response=new ProcessResponse(0,1,700,100.0,LocalDate.now().plusDays(2));
		when(integralPartService.processDetails(Mockito.anyInt())).thenReturn(response);
		ProcessResponse expectedResponse=new ProcessResponse(0,1,700,100.0,LocalDate.now().plusDays(2));
		ProcessResponse actualResponse=componentProcessingController.getProcessingDetails("wevfhqwfvehfv68", processRequest);
		assertEquals(expectedResponse.toString(),actualResponse.toString());
	}
	
	/* 
	 * Test method to check functionality of getProcessingDetails()
	 * when jwt token is valid and component Type is Integral and request is not a Priority
	 */
	@Test
	void testGetProcessingDetails_Authenticated_And_Integral_Not_Priority() throws InvalidTokenException 
	{
		ProcessRequest processRequest = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				false);
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",true));
		AuthenticationResponse auth=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(auth);
		ProcessResponse response=new ProcessResponse(0,1,500,100.0,LocalDate.now().plusDays(5));
		when(integralPartService.processDetails(Mockito.anyInt())).thenReturn(response);
		ProcessResponse expectedResponse=new ProcessResponse(0,1,500,100.0,LocalDate.now().plusDays(5));
		ProcessResponse actualResponse=componentProcessingController.getProcessingDetails("wevfhqwfvehfv68", processRequest);
		assertEquals(expectedResponse.toString(),actualResponse.toString());
	}
	
	/* 
	 * Test method to check functionality of getProcessingDetails()
	 * when jwt token is valid and component Type is Accessory and request is Priority(default)
	 */
	
	@Test
	void testGetProcessingDetails_Authenticated_And_Accessory() throws InvalidTokenException 
	{
		ProcessRequest processRequest = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Accessory", "Earphone", 2,
				true);
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",true));
		AuthenticationResponse auth=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(auth);
		ProcessResponse response=new ProcessResponse(0,1,300,100.0,LocalDate.now().plusDays(5));
		when(accessoryPartService.processDetails(Mockito.anyInt())).thenReturn(response);
		ProcessResponse expectedResponse=new ProcessResponse(0,1,300,100.0,LocalDate.now().plusDays(5));
		ProcessResponse actualResponse=componentProcessingController.getProcessingDetails("wevfhqwfvehfv68", processRequest);
		assertEquals(expectedResponse.toString(),actualResponse.toString());
	}
	
	/* 
	 * Test method to check functionality of paymentProcessing()
	 * when jwt token is Invalid 
	 */
	
	@Test
	void testPaymentProcessing_UnAuthenticated() 
	{
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",false));
		AuthenticationResponse auth=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(auth);
		assertThrows(InvalidTokenException.class, ()->componentProcessingController.paymentProcessing("wevfhqwfvehfv68", 1, 1234567890, 7000, 1000));
	}
	
	/* 
	 * Test method to check functionality of paymentProcessing()
	 * when jwt token is valid 
	 */
	
	@Test
	void testPaymentProcessing_Authenticated() throws InvalidTokenException
	{
		String expectedOutput = "Payment Successful.Thank you for using our Service";
		Optional<AuthenticationResponse> authenticationResponse=Optional.of(new AuthenticationResponse("wevfhqwfvehfv68",true));
		AuthenticationResponse auth=authenticationResponse.get();
		when(authenticationFeignClient.getValidity(Mockito.anyString())).thenReturn(auth);
		when(paymentService.completeProcessing(1, 1234567890, 7000, 1000)).thenReturn("Payment Successful.Thank you for using our Service");
		assertEquals(expectedOutput,componentProcessingController.paymentProcessing("wevfhqwfvehfv68", 1, 1234567890, 7000, 1000));
	}
}
