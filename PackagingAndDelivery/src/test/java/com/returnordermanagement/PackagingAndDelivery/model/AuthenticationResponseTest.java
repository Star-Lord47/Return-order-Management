package com.returnordermanagement.PackagingAndDelivery.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.returnordermanagement.packaginganddelivery.model.AuthenticationResponse;

import lombok.extern.slf4j.Slf4j;

/*
 * This class is used to test whether setter,getter,To string, Constructor given the expected result. 
 */
@RunWith(SpringRunner.class)
@Slf4j
public class AuthenticationResponseTest {
	@Mock
	private AuthenticationResponse auth;

	@Before
	public void setup() {
		log.info("Start");
		auth = new AuthenticationResponse();
		auth.setJwtToken("eyJhbGciOiJIUzI1NiJ9");
		auth.setValid(true);
		log.info("End");
	}

	@Test
	public void testAuthenticationDetails() throws Exception {
		log.info("Start");
		assertEquals("eyJhbGciOiJIUzI1NiJ9", auth.getJwtToken());
		assertEquals(true, auth.getValid());
		log.info("End");

	}

	@Test
	public void testAllArgsConstructor() {

		AuthenticationResponse auth = new AuthenticationResponse("eyJhbGciOiJIUzI1NiJ9", true);
		assertEquals("eyJhbGciOiJIUzI1NiJ9", auth.getJwtToken());
	}

	@Test
	public void testToStringMethod() {
		log.info("Start");
		assertEquals(auth.toString(), auth.toString());
		log.info("End");
	}

	@Test
	public void testSetters() {
		auth.setValid(false);
		;
		assertEquals(false, auth.getValid());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = auth.equals(auth);
		assertTrue(equals);
	}

	/**
	 * Tests the hashCode() method
	 */
	@Test
	public void testHashCodeMethod() {
		int hashCode = auth.hashCode();
		assertEquals(hashCode, auth.hashCode());
	}
}
