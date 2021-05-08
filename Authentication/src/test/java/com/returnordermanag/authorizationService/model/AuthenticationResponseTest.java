package com.returnordermanag.authorizationService.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnordermanagement.authorizationService.model.AuthenticationResponse;

 class AuthenticationResponseTest {
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	
	@Test
	void testSetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testSetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	
	
	@Test
	void testGetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testGetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testConstructor() {
		AuthenticationResponse ares = new AuthenticationResponse("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I", true);
		
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGl2YW0iLCJleHAiOjE2MTk5NTg4NDMsImlhdCI6MTYxOTk1NzA0M30.QMryZ-IwhVDBgXXGFkrz5h6YEl-aOwG52mcaq56I56I",ares.getJwtToken());
		assertEquals(true,ares.getValid());
	}
}