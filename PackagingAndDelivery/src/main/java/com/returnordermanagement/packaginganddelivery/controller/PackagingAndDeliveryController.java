package com.returnordermanagement.packaginganddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagement.packaginganddelivery.client.AuthenticationFeignClient;
import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;
import com.returnordermanagement.packaginganddelivery.exception.TokenInvalidException;
import com.returnordermanagement.packaginganddelivery.service.PackagingAndDeliveryServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PackagingAndDeliveryController {

	@Autowired
	public PackagingAndDeliveryServiceImpl packagingAndDeliveryService;

	@Autowired
	AuthenticationFeignClient authenticationFeignClient;

	/**
	 * This method returns packagingAndDeliveryCostDetail code after component type
	 * and count of component type in service class.
	 * 
	 * @param componentType, count
	 * @throws TokenInvalidException, ComponentTypeNotFound
	 * @return packagingAndDeliveryService.getPackingAndDeliveryCharge(componentType,
	 *         count)
	 * @throws ComponentTypeNotFound
	 */

	@GetMapping("/PackagingAndDeliveryCharge/{componentType}/{count}")
	@ResponseStatus(code = HttpStatus.OK)
	public double packagingAndDeliveryCostDetail(@PathVariable String componentType, @PathVariable int count)
			throws TokenInvalidException, ComponentTypeNotFound {

		log.info("PackagingAndDeliveryCharge controller  :: Started sending Request to Service");

		// return packgingAndDeliveryService to get the calculate result
		return packagingAndDeliveryService.getPackingAndDeliveryCharge(componentType, count);
	}

}
