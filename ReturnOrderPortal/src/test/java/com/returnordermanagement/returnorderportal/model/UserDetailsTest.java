package com.returnordermanagement.returnorderportal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserDetailsTest {

	User userDetails = new User();

	@Test
	void testGetUserID() {
		userDetails.setUserId(1);
		assertEquals(1, userDetails.getUserId());
	}

	@Test
	void testSetUserID() {
		userDetails.setUserId(1);
		assertEquals(1, userDetails.getUserId());
	}

	@Test
	void testGetUserName() {
		userDetails.setUsername("Manan");
		assertEquals("Manan", userDetails.getUsername());
	}

	@Test
	void testSetUserName() {
		userDetails.setUsername("Manan");
		assertEquals("Manan", userDetails.getUsername());
	}

	@Test
	void testGetPassword() {
		userDetails.setPassword("Abhishek");
		assertEquals("Abhishek", userDetails.getPassword());
	}

	@Test
	void testSetPassword() {
		userDetails.setPassword("Abhishek");
		assertEquals("Abhishek", userDetails.getPassword());
	}

	@Test
	void testGetJwtToken() {
		userDetails.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				userDetails.getJwtToken());
	}

	@Test
	void testSetJwtToken() {
		userDetails.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				userDetails.getJwtToken());
	}

	@Test
	void testIsValid() {
		userDetails.setValid(true);
		assertEquals(true, userDetails.isValid());
	}

	@Test
	void testSetValid() {
		userDetails.setValid(true);
		assertEquals(true, userDetails.isValid());
	}

	@Test
	void testConstructor() {
		User ud = new User(1, "Manan", "Manan",
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				true);
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",
				ud.getJwtToken());
		assertEquals(1, ud.getUserId());
		assertEquals("Manan", ud.getUsername());
		assertEquals("Manan", ud.getPassword());
		assertEquals(true, ud.isValid());
	}
}