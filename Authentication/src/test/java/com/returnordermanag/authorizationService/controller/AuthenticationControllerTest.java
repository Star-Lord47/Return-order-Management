package com.returnordermanag.authorizationService.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.returnordermanagement.authorizationService.controller.AuthenticationController;
import com.returnordermanagement.authorizationService.exception.BadCredentialException;
import com.returnordermanagement.authorizationService.model.AuthenticationRequest;
import com.returnordermanagement.authorizationService.model.AuthenticationResponse;
import com.returnordermanagement.authorizationService.service.MyUserDetailsService;
import com.returnordermanagement.authorizationService.service.ValidateService;
import com.returnordermanagement.authorizationService.util.JwtUtil;



@ExtendWith(MockitoExtension.class) 
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AuthenticationControllerTest {
	
	@InjectMocks
	AuthenticationController authController;
	
	@InjectMocks
	AuthenticationResponse authResponse;
	
	@Mock
	AuthenticationManager authenticationManager;
	
	@Mock
	MyUserDetailsService userDetailsService;
	
	@Mock
	JwtUtil jwtTokenUtil;
	
	@Mock
	ValidateService validateService;
	
	@Mock
	AuthenticationResponse authenticationResponse;
	
	
	
	UserDetails userDetails;
	
	@InjectMocks
	JwtUtil jwtToken;

	
	@Test
	void createAuthenticationTokenTest() throws BadCredentialException {
		AuthenticationRequest authRequest = new AuthenticationRequest("Shivam","shivam");
		 ResponseEntity<?> response=authController.createAuthenticationToken(authRequest);
		 assertEquals( 200 , response.getStatusCodeValue() );
		
	}
	
	
	@Test
	void createAuthenticationTokenTestFailed() throws BadCredentialException {
		AuthenticationRequest authRequest = new AuthenticationRequest("Shivam","bhargav");
		 ResponseEntity<?> response=authController.createAuthenticationToken(authRequest);	 
		 assertNotNull(response);
		
	}
	
	@Test
	void getValidityFailTest() {	
		userDetails = new User("Shivam", "shivam", new ArrayList<>());
		String generateToken = jwtToken.generateToken(userDetails);
		Boolean response=jwtTokenUtil.validateToken(generateToken);
		assertEquals(false,response);
	}

}

