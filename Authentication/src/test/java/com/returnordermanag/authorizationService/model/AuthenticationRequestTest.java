package com.returnordermanag.authorizationService.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import com.returnordermanagement.authorizationService.model.AuthenticationRequest;
class AuthenticationRequestTest {

	AuthenticationRequest authenticationRequest = new AuthenticationRequest();
	
	
	
	@Test
	void testGetUserName() {
		authenticationRequest.setUsername("Shivam");
		assertEquals("Shivam", authenticationRequest.getUsername());
	}
	
	@Test
	void testSetUserName() {
		authenticationRequest.setUsername("Shiavam");
		assertEquals("Shiavam", authenticationRequest.getUsername());
	}
	@Test
	void testGetPassword() {
		authenticationRequest.setPassword("$2y$12$CrrjYf/vAy.l3.bzwdMFw.25BxFm.jPWju897S7dQxsR9kcq1S/5y");
		assertEquals("$2y$12$CrrjYf/vAy.l3.bzwdMFw.25BxFm.jPWju897S7dQxsR9kcq1S/5y", authenticationRequest.getPassword());
	}
	
	@Test
	void testSetPassword() {
		authenticationRequest.setPassword("shivam");
		assertEquals("shivam", authenticationRequest.getPassword());
	}
	
	@Test
	void testConstructor() {
		AuthenticationRequest ar = new AuthenticationRequest("Shivam", "shivam");
		assertEquals("Shivam", ar.getUsername());
		assertEquals("shivam", ar.getPassword());
	}
}
