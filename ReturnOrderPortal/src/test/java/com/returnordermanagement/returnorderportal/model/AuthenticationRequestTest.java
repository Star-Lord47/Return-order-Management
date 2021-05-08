package com.returnordermanagement.returnorderportal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthenticationRequestTest {

	AuthenticationRequest authenticationRequest = new AuthenticationRequest();

	@Test
	void testGetUserName() {
		authenticationRequest.setUsername("Manan");
		assertEquals("Manan", authenticationRequest.getUsername());
	}

	@Test
	void testSetUserName() {
		authenticationRequest.setUsername("Manan");
		assertEquals("Manan", authenticationRequest.getUsername());
	}

	@Test
	void testGetPassword() {
		authenticationRequest.setPassword("Manan");
		assertEquals("Manan", authenticationRequest.getPassword());
	}

	@Test
	void testSetPassword() {
		authenticationRequest.setPassword("Manan");
		assertEquals("Manan", authenticationRequest.getPassword());
	}

	@Test
	void testConstructor() {
		AuthenticationRequest ar = new AuthenticationRequest("Manan", "Manan");
		assertEquals("Manan", ar.getUsername());
		assertEquals("Manan", ar.getPassword());
	}
}