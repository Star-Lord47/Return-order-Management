package com.returnordermanagementsystem.componentprocessing.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProcessRequestTest {
	ProcessRequest processRequest = new ProcessRequest();

	/*
	 * This class contains 
	 * Test methods to check the functionality of getter,setter,toString and Constructor of
	 * ProcessRequest Class
	 */
	@Test
	void testGetUserId() {
		processRequest.setUserId(1);
		assertEquals(1, processRequest.getUserId());
	}

	@Test
	void testSetUserID() {
		processRequest.setUserId(1);
		assertEquals(1, processRequest.getUserId());
	}

	@Test
	void testGetUserName() {
		processRequest.setUserName("Shivam");
		assertEquals("Shivam", processRequest.getUserName());
	}

	@Test
	void testSetUserName() {
		processRequest.setUserName("Shivam");
		assertEquals("Shivam", processRequest.getUserName());
	}

	@Test
	void testGetContactNumber() {
		processRequest.setContactNumber(987654321);
		assertEquals(987654321, processRequest.getContactNumber());
	}

	@Test
	void testSetContactNumber() {
		processRequest.setContactNumber(987654321);
		assertEquals(987654321, processRequest.getContactNumber());
	}

	@Test
	void testGetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testGetComponentType() {
		processRequest.setComponentType("Integral");
		assertEquals("Integral", processRequest.getComponentType());
	}

	@Test
	void testSetComponentType() {
		processRequest.setComponentType("Integral");
		assertEquals("Integral", processRequest.getComponentType());
	}

	@Test
	void testGetComponentName() {
		processRequest.setComponentName("Display");
		assertEquals("Display", processRequest.getComponentName());
	}

	@Test
	void testSetComponentName() {
		processRequest.setComponentName("Display");
		assertEquals("Display", processRequest.getComponentName());
	}

	@Test
	void testGetQuantityOfDefective() {
		processRequest.setNumberOfDefective(1);
		assertEquals(1, processRequest.getNumberOfDefective());
	}

	@Test
	void testSetQuantityOfDefective() {
		processRequest.setNumberOfDefective(1);
		assertEquals(1, processRequest.getNumberOfDefective());
	}

	@Test
	void testGetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}

	@Test
	void testSetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}

	@Test
	void testConstructor() {
		ProcessRequest processRequest1 = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				true);
		assertEquals(1, processRequest1.getUserId());
		assertEquals("Shivam", processRequest1.getUserName());
		assertEquals(976687565, processRequest1.getContactNumber());
		assertEquals(1234567, processRequest1.getCreditCardNumber());
		assertEquals("Integral", processRequest1.getComponentType());
		assertEquals("Display", processRequest1.getComponentName());
		assertEquals(2, processRequest1.getNumberOfDefective());
		assertTrue(processRequest1.isPriorityRequest());

	}

	@Test
	void testToString() {
		ProcessRequest processRequest1 = new ProcessRequest(1, "Shivam", 976687565, 1234567, "Integral", "Display", 2,
				true);
		assertEquals(
				"ProcessRequest(userId=1, userName=Shivam, contactNumber=976687565, creditCardNumber=1234567, componentType=Integral, componentName=Display, numberOfDefective=2, isPriorityRequest=true)",
				processRequest1.toString());
	}
}
