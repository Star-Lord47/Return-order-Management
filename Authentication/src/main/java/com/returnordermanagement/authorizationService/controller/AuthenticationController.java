package com.returnordermanagement.authorizationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagement.authorizationService.exception.BadCredentialException;
import com.returnordermanagement.authorizationService.model.AuthenticationRequest;
import com.returnordermanagement.authorizationService.model.AuthenticationResponse;
import com.returnordermanagement.authorizationService.service.MyUserDetailsService;
import com.returnordermanagement.authorizationService.service.ValidateService;
import com.returnordermanagement.authorizationService.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private ValidateService validateService;

	// Rest endpoint
	/*
	 * @RequestMapping({ "/hello" }) public String firstPage() { return
	 * "Hello World"; }
	 */

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws BadCredentialException, NullPointerException {
		boolean isvalid=true;
		log.info("Login Authenticating");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException NullPointerException) {
			log.info("Bad Credential");
			isvalid=false;
			throw new BadCredentialException();
			
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, isvalid));
	}

	@GetMapping("/validate")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token) {

		/*
		 * validating token extraction from authorization header>> check the validity of
		 * token>> return an athenticationResponse Instance with two attributes String
		 * jwtToken , Boolean valid
		 * 
		 */

		log.info("Validate token");
		return validateService.validate(token);
	}

}
