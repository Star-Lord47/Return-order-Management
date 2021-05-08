package com.returnordermanagement.packaginganddelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnordermanagement.packaginganddelivery.model.AuthenticationResponse;

/*
 * Authentication Integration from Authentication Micro-Service
 */
@FeignClient(name = "${authentication-service-name}", url = "${authentication-service-url}")
public interface AuthenticationFeignClient {

	@GetMapping(value = "/validate")
	AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
}
