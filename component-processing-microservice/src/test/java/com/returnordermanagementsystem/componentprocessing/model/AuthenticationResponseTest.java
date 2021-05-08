package com.returnordermanagementsystem.componentprocessing.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	/*
	 * Test method to check functionality of setJwtToken()
	 */
	
	@Test
	void testSetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				authenticationResponse.getJwtToken());
	}
	
	/*
	 * Test method to check functionality of setValid()
	 */

	@Test
	void testSetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.isValid());
	}
	
	/*
	 * Test method to check functionality of getJwtToken()
	 */
	
	@Test
	void testGetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				authenticationResponse.getJwtToken());
	}
	
	/*
	 * Test method to check functionality of getValid()
	 */
	
	@Test
	void testGetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.isValid());
	}
}
