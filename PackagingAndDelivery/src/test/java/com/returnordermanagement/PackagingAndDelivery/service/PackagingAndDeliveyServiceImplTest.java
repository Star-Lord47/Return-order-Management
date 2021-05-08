package com.returnordermanagement.PackagingAndDelivery.service;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;
import com.returnordermanagement.packaginganddelivery.service.PackagingAndDeliveryServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PackagingAndDeliveyServiceImplTest {

	@InjectMocks
	private PackagingAndDeliveryServiceImpl packagingAndDeliveryService;

	/*
	 * This method is used to test whether getPackingAndDeliveryCharge returns
	 * required values.
	 * 
	 * @throws ComponentTypeNotFound Exception
	 */

	/*
	 * This test method is used to test whether return the object for
	 * PackagingAndDeliveryService or Not.
	 */

	@Test
	void testNotNullPackagingAndDeliveryServiceObject() {
		assertNotNull(packagingAndDeliveryService);
	}

	/*
	 * This method is used to test whether getPackingAndDeliveryCharge returns
	 * required values for Integral As Component.
	 * 
	 * @throws ComponentTypeNotFound Exception
	 */
	@Test
	void PackageAndDeliveryTestForIntegral() throws ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 10);
		double expectedResult = 3500;
		Assertions.assertEquals(expectedResult, actualResult);

	}

	/*
	 * This method is used to test whether getPackingAndDeliveryCharge set the
	 * required parameters for Integral Component.
	 * 
	 * @throws ComponentTypeNotFound Exception
	 */
	@Test
	void testSetters() throws ComponentTypeNotFound {
		Assertions.assertEquals(1750.0, packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 5));
	}

	

	/*
	 * This method is used to test whether getPackingAndDeliveryCharge returns
	 * parameters for Accessory Component.
	 * 
	 * @throws ComponentTypeNotFound Exception
	 */
	@Test
	void PackageAndDeliveryTestForAccessory() throws ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory", 10);
		double expectedResult = 2000.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	/*
	 * This method is used to test whether getPackingAndDeliveryCharge returns
	 * required values for count as 0 for Integral Component.
	 * @throws ComponentTypeNotFound Exception
	 */
	@Test
	void PackageAndDeliveryTestForCountIsZero() throws ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 0);
		double expectedResult = 0.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestWrongIntegral() throws ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Integral", 5);
		double expectedResult = 0.0;
		Assertions.assertNotEquals(expectedResult, actualResult);
	}
	
	/*
	 * This method is used to test whether getPackingAndDeliveryCharge returns
	 * required values for count as 0 for Accessory Component.
	 * @throws ComponentTypeNotFound Exception
	 */
	@Test
	void PackageAndDeliveryTestWrongAccessory() throws ComponentTypeNotFound {
		double actualResult = packagingAndDeliveryService.getPackingAndDeliveryCharge("Accessory", 0);
		double expectedResult = 700.0;
		Assertions.assertNotEquals(expectedResult, actualResult);
	}

}
