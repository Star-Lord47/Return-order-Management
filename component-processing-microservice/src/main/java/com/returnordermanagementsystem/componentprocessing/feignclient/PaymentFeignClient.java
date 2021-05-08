package com.returnordermanagementsystem.componentprocessing.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${payment-service-name}", url = "${payment-service-url}")
public interface PaymentFeignClient {

	/* Extracting available balance of credit card 
	 * from Payment Microservice 
	 */
	@GetMapping(value = "/{cardNumber}/{charge}")
	double getCurrentBalance(@PathVariable long cardNumber, @PathVariable double charge);
}
