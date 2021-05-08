package com.returnordermanagement.PackagingAndDelivery.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanagement.packaginganddelivery.controller.PackagingAndDeliveryController;
import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;
import com.returnordermanagement.packaginganddelivery.exception.TokenInvalidException;
import com.returnordermanagement.packaginganddelivery.service.PackagingAndDeliveryServiceImpl;

@SpringBootTest
/*
 * This test methods is used to test whether getPackingAndDeliveryCharge returns
 * required values Components from Controller.
 * @throws ComponentTypeNotFound Exception
 */
@ExtendWith(MockitoExtension.class)
class PackagingAndDeliveryControllerTest {

	
	
	@Autowired
	PackagingAndDeliveryController pdc;

	@Autowired
	private PackagingAndDeliveryServiceImpl packagingAndDeliveryService;
	
	


	@Test
	void PackageAndDeliveryTestForIntegral() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = pdc.packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 10);
		double  expectedResult = 3500.0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForAccessory() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory",10);
		double expectedResult = 2000.0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForCountIsZero() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory", 0);
		double expectedResult = 0.0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void PackageAndDeliveryTestAnotherAccessory() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory", 5);
		double expectedResult = 1000;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void PackageAndDeliveryTestWrongAccessory() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory", 5);
		double expectedResult = 9000;
		assertNotEquals(expectedResult, actualResult);
	}
	
	@Test
	void PackageAndDeliveryTestWrongIntegral() throws TokenInvalidException, ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 5);
		double expectedResult = 9000;
		assertNotEquals(expectedResult, actualResult);
	}



}