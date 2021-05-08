package com.returnordermanagement.returnorderportal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ProcessResponseTest {
	ProcessResponse processResponse = new ProcessResponse();

	@Test
	void testGetRequestID() {
		processResponse.setRequestId(11);
		assertEquals(11, processResponse.getRequestId());
	}

	@Test
	void testSetRequestID() {
		processResponse.setRequestId(11);
		assertEquals(11, processResponse.getRequestId());
	}

	@Test
	void testGetUserID() {
		processResponse.setUserId(1);
		assertEquals(1, processResponse.getUserId());
	}

	@Test
	void testSetUserID() {
		processResponse.setUserId(1);
		assertEquals(1, processResponse.getUserId());
	}

	@Test
	void testGetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}

	@Test
	void testSetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}

	@Test
	void testGetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}

	@Test
	void testSetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}

	@Test
	void testGetDateOfDelivery() {
		processResponse.setDateOfDelivery(LocalDate.of(2021, 04, 30).plusDays(5));
		assertEquals(LocalDate.of(2021, 05, 05), processResponse.getDateOfDelivery());
	}

	@Test
	void testSetDateOfDelivery() {
		processResponse.setDateOfDelivery(LocalDate.of(2021, 04, 30).plusDays(2));
		assertEquals(LocalDate.of(2021, 05, 02), processResponse.getDateOfDelivery());
	}

	@Test
	void testConstructor() {
		ProcessResponse processResponse1=new ProcessResponse(1, 101, 500, 100,LocalDate.of(2021, 04, 30).plusDays(2));
		assertEquals(1, processResponse1.getRequestId());
		assertEquals(101, processResponse1.getUserId());
		assertEquals(500, processResponse1.getProcessingCharge());
		assertEquals(100, processResponse1.getPackagingAndDeliveryCharge());
		assertEquals(LocalDate.of(2021, 05, 02), processResponse1.getDateOfDelivery());
	}
	@Test
	void testToString()
	{
		ProcessResponse processResponse1=new ProcessResponse(1, 101, 500, 100,LocalDate.of(2021, 04, 30).plusDays(2));
		assertEquals("ProcessResponse(requestId=1, userId=101, processingCharge=500.0, packagingAndDeliveryCharge=100.0, dateOfDelivery=2021-05-02)",processResponse1.toString());
	}

}