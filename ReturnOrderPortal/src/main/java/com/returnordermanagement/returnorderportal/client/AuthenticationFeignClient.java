package com.returnordermanagement.returnorderportal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.returnordermanagement.returnorderportal.model.AuthenticationRequest;
import com.returnordermanagement.returnorderportal.model.AuthenticationResponse;

@FeignClient(name = "${authentication-service-name}", url = "${authentication-service-url}")
public interface AuthenticationFeignClient {
	
	@PostMapping("/login")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest);
}

