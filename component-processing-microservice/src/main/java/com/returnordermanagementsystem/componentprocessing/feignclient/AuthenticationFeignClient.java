package com.returnordermanagementsystem.componentprocessing.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnordermanagementsystem.componentprocessing.model.AuthenticationResponse;

@FeignClient(name = "${authentication-service-name}", url = "${authentication-service-url}")
public interface AuthenticationFeignClient {

	/* Verifying the jwt token 
	 * from Authentication Microservice 
	 */
	@GetMapping(value = "/validate")
	AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
}