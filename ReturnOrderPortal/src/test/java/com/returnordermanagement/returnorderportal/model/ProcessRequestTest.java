package com.returnordermanagement.returnorderportal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProcessRequestTest {
	ProcessRequest processRequest = new ProcessRequest();

	@Test
	void testGetUserID() {
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
		processRequest.setUserName("Manan");
		assertEquals("Manan", processRequest.getUserName());
	}

	@Test
	void testSetUserName() {
		processRequest.setUserName("Manan");
		assertEquals("Manan", processRequest.getUserName());
	}

	@Test
	void testGetContactNumber() {
		processRequest.setContactNumber(818099929);
		assertEquals(818099929, processRequest.getContactNumber());
	}

	@Test
	void testSetContactNumber() {
		processRequest.setContactNumber(818099929);
		assertEquals(818099929, processRequest.getContactNumber());
	}

	@Test
	void testGetCreditCardNumber() {
		processRequest.setCreditCardNumber(818099929);
		assertEquals(818099929, processRequest.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testGetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}

	@Test
	void testSetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}

	@Test
	void testGetComponentTypeAccessory() {
		processRequest.setComponentType("accessory");
		assertEquals("accessory", processRequest.getComponentType());
	}

	@Test
	void testSetComponentTypeAccessory() {
		processRequest.setComponentType("accessory");
		assertEquals("accessory", processRequest.getComponentType());
	}

	@Test
	void testGetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}

	@Test
	void testSetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}

	@Test
	void testGetQuantityOfDefective() {
		processRequest.setNumberOfDefective(1);
		;
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
		ProcessRequest pr = new ProcessRequest(101, "Manan", 987456123, 1234567890, "integral", "laptop", 1, true);
		assertEquals(101, pr.getUserId());
		assertEquals("Manan", pr.getUserName());
		assertEquals(987456123, pr.getContactNumber());
		assertEquals(1234567890, pr.getCreditCardNumber());
		assertEquals("integral", pr.getComponentType());
		assertEquals("laptop", pr.getComponentName());
		assertEquals(1, pr.getNumberOfDefective());
		assertEquals(true, pr.isPriorityRequest());
	}

	@Test
	void testConstructorForAccessory() {
		ProcessRequest pr = new ProcessRequest(101, "Manan", 987456123, 1234567890, "accessory", "laptop", 1, true);
		assertEquals(101, pr.getUserId());
		assertEquals("Manan", pr.getUserName());
		assertEquals(987456123, pr.getContactNumber());
		assertEquals(1234567890, pr.getCreditCardNumber());
		assertEquals("accessory", pr.getComponentType());
		assertEquals("laptop", pr.getComponentName());
		assertEquals(1, pr.getNumberOfDefective());
		assertEquals(true, pr.isPriorityRequest());
	}

	@Test
	void testConstructorNoPriority() {
		ProcessRequest pr = new ProcessRequest(101, "Manan", 987456123, 1234567890, "integral", "laptop", 1, false);
		assertEquals(101, pr.getUserId());
		assertEquals("Manan", pr.getUserName());
		assertEquals(987456123, pr.getContactNumber());
		assertEquals(1234567890, pr.getCreditCardNumber());
		assertEquals("integral", pr.getComponentType());
		assertEquals("laptop", pr.getComponentName());
		assertEquals(1, pr.getNumberOfDefective());
		assertEquals(false, pr.isPriorityRequest());
	}

	@Test
	void testConstructorAccessoryNoPriority() {
		ProcessRequest pr = new ProcessRequest(101, "Manan", 987456123, 1234567890, "accessory", "laptop", 1, false);
		assertEquals(101, pr.getUserId());
		assertEquals("Manan", pr.getUserName());
		assertEquals(987456123, pr.getContactNumber());
		assertEquals(1234567890, pr.getCreditCardNumber());
		assertEquals("accessory", pr.getComponentType());
		assertEquals("laptop", pr.getComponentName());
		assertEquals(1, pr.getNumberOfDefective());
		assertEquals(false, pr.isPriorityRequest());
	}

	@Test
	void testToString() {
		ProcessRequest processRequest1 = new ProcessRequest(1, "Manan", 818099929, 1234567, "Integral", "Display", 2,
				true);
		assertEquals(
				"ProcessRequest(userId=1, userName=Manan, contactNumber=818099929, creditCardNumber=1234567, componentType=Integral, componentName=Display, numberOfDefective=2, isPriorityRequest=true)",
				processRequest1.toString());
	}
}