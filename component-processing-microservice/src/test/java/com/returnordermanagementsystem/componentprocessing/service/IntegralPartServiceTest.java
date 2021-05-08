package com.returnordermanagementsystem.componentprocessing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.returnordermanagementsystem.componentprocessing.feignclient.PackagingAndDeliveryFeignClient;
import com.returnordermanagementsystem.componentprocessing.model.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.model.ProcessResponse;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessRequestRepository;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessResponseRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class IntegralPartServiceTest {

	@Autowired
	IntegralPartService integralPartService;
	
	@MockBean
	private ProcessRequestRepository processRequestRepository;

	@MockBean
	private ProcessResponseRepository processResponseRepository;

	@MockBean
	private PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient;
	
	/* 
	 * Test method to check functionality of processDetails()
	 * when component Type is Integral and request is Priority Request
	 */
	
	@Test
	void testProcessDetails_PriorityRequest()
	{
		Optional<ProcessRequest> processRequest = Optional.of(new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				true));
		when(processRequestRepository.findById(1)).thenReturn(processRequest);
		when(packagingAndDeliveryFeignClient.getPackagingAndDeliveryCharge(Mockito.anyString(), Mockito.anyInt())).thenReturn(100.0);
		ProcessResponse expectedResponse=new ProcessResponse(0,1,700,100.0,LocalDate.now().plusDays(2));
		ProcessResponse actualResponse=integralPartService.processDetails(1);	
		assertEquals(expectedResponse.toString(), actualResponse.toString());
	}
	
	/* 
	 * Test method to check functionality of processDetails()
	 * when component Type is Integral and request is not a Priority Request
	 */
	
	@Test
	void testProcessDetails_NotPriorityRequest()
	{
		Optional<ProcessRequest> processRequest = Optional.of(new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				false));
		when(processRequestRepository.findById(1)).thenReturn(processRequest);
		when(packagingAndDeliveryFeignClient.getPackagingAndDeliveryCharge(Mockito.anyString(), Mockito.anyInt())).thenReturn(100.0);
		ProcessResponse expectedResponse=new ProcessResponse(0,1,500,100.0,LocalDate.now().plusDays(5));
		ProcessResponse actualResponse=integralPartService.processDetails(1);	
		assertEquals(expectedResponse.toString(), actualResponse.toString());
	}
}
