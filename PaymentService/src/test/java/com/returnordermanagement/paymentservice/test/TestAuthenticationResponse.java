package com.returnordermanagement.paymentservice.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.returnordermanagement.paymentservice.model.AuthenticationResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestAuthenticationResponse {
	@Mock
	private AuthenticationResponse auth;

	@Test
	void testAuthenticationDetails() {
		log.info("Start");
		auth = new AuthenticationResponse();
		auth.setJwtToken("abcdefgh");
		auth.setValid(true);
		assertEquals("abcdefgh", auth.getJwtToken());
		assertEquals(true, auth.getValid());
		log.info("End");

	}

	@Test
	void testAllArgsConstructor() {

		AuthenticationResponse auth = new AuthenticationResponse("eyJhbGciOiJIUzI1NiJ9", true);
		assertEquals("eyJhbGciOiJIUzI1NiJ9", auth.getJwtToken());
	}

	@Test
	void testToStringMethod() {
		log.info("Start");
		auth = new AuthenticationResponse();
		auth.setJwtToken("abcdefgh");
		auth.setValid(true);
		assertEquals(auth.toString(), auth.toString());
		log.info("End");
	}

	@Test
	void testSetters() {
		auth = new AuthenticationResponse();
		auth.setJwtToken("abcdefgh");
		auth.setValid(false);
		assertEquals(false, auth.getValid());
	}

	@Test
	void testEqualsMethod() {
		auth = new AuthenticationResponse();
		auth.setJwtToken("abcdefgh");
		auth.setValid(true);
		boolean equals = auth.equals(auth);
		assertTrue(equals);
	}

	/**
	 * Tests the hashCode() method
	 */
	@Test
	void testHashCodeMethod() {
		auth = new AuthenticationResponse();
		auth.setJwtToken("abcdefgh");
		auth.setValid(true);
		int hashCode = auth.hashCode();

		assertEquals(hashCode, auth.hashCode());
	}
}
