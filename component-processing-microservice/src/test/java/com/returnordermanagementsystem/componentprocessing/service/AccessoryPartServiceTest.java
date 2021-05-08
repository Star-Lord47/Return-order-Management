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


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AccessoryPartServiceTest {

	@Autowired
	AccessoryPartService accessoryPartService;

	@MockBean
	private ProcessRequestRepository processRequestRepository;

	@MockBean
	private PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient;

	/* 
	 * Test method to check functionality of processDetails()
	 * when component Type is Accessory
	 */
	
	@Test
	void testProcessDetails()
	{
		Optional<ProcessRequest> processRequest = Optional.of(new ProcessRequest(1, "Shivam", 976687565, 1234567, "Accessory", "Earphone", 2,
				false));
		when(processRequestRepository.findById(1)).thenReturn(processRequest);
		when(packagingAndDeliveryFeignClient.getPackagingAndDeliveryCharge(Mockito.anyString(), Mockito.anyInt())).thenReturn(100.0);
		ProcessResponse expectedResponse=new ProcessResponse(1,1,300,100.0,LocalDate.now().plusDays(5));
		ProcessResponse actualResponse=accessoryPartService.processDetails(1);	
		assertEquals(expectedResponse.toString(), actualResponse.toString());
	}

}
