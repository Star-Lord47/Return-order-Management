package com.returnordermanagementsystem.componentprocessing.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${packaginganddelivery-service-name}", url = "${packaginganddelivery-service-url}")
public interface PackagingAndDeliveryFeignClient {

	/* Extracting Packaging and Delivery Charge 
	 * from PackagingAndDelivery Microservice 
	 */
	@GetMapping(value = "/{componentType}/{count}")
	double getPackagingAndDeliveryCharge(@PathVariable("componentType") String componentType,
			@PathVariable("count") int count);
}
