package com.returnordermanagementsystem.componentprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagementsystem.componentprocessing.exception.InvalidTokenException;
import com.returnordermanagementsystem.componentprocessing.exception.UnknownException;
import com.returnordermanagementsystem.componentprocessing.feignclient.AuthenticationFeignClient;
import com.returnordermanagementsystem.componentprocessing.model.AuthenticationResponse;
import com.returnordermanagementsystem.componentprocessing.model.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.model.ProcessResponse;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessRequestRepository;
import com.returnordermanagementsystem.componentprocessing.service.AccessoryPartService;
import com.returnordermanagementsystem.componentprocessing.service.IntegralPartService;
import com.returnordermanagementsystem.componentprocessing.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ComponentProcessingController {

	@Autowired
	private IntegralPartService integralPartService;
	@Autowired
	private AccessoryPartService accessoryPartService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ProcessRequestRepository processRequestRepository;
	@Autowired
	private AuthenticationFeignClient authenticationFeignClient;

	@Value("${componentType.integral}")
	private String componentTypeIntegral;
	@Value("${componentType.accessory}")
	private String componentTypeAccessory;
	@Value("${exception.message}")
	private String exceptionMessage;
	@Value("${invalidTokenException.message}")
	private String invalidTokenExceptionMessage;

	/*
	 * This method accepts ProcessRequest as parameters
	 * 
	 * @param RequestHeader("Authorization") to extract the token from header Post
	 * 
	 * @param processRequest Authorization using JWT, based upon the type of
	 * component– Integral or Accessory the method returns the appropriate response
	 * 
	 * @return response
	 */

	@PostMapping("/service")
	public ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token,
			@RequestBody ProcessRequest processRequest) throws InvalidTokenException {
		log.info("Started getProcessingDetails() method in Component processing Controller");
		try {
			AuthenticationResponse authenticationResponse = null;
			log.info("Authenticating Request Token");
			authenticationResponse = authenticationFeignClient.getValidity(token);
			if (authenticationResponse.isValid()) {
				log.info("JWT Token verified");
			} else {
				log.info("JWT Token Expired");
				throw new InvalidTokenException(invalidTokenExceptionMessage);
			}
		} catch (Exception exception) {
			log.info("Something went wrong in Authentication Microservice");
			log.debug("Exception {} ", exception.getMessage());
			throw new UnknownException(exceptionMessage);
		}
		processRequestRepository.save(processRequest);
		log.info("Saved Process Request");

		ProcessResponse response = null;

		int userId = processRequest.getUserId();
		String componentType = processRequest.getComponentType();

		if (componentType.equals(componentTypeIntegral))
			response = integralPartService.processDetails(userId);
		else if (componentType.equals(componentTypeAccessory))
			response = accessoryPartService.processDetails(userId);

		return response;
	}

	/*
	 * This method accepts following parameters
	 * 
	 * @param RequestHeader("Authorization") to extract the token from header checks
	 * 
	 * @param requestId
	 * 
	 * @param creditCardNumber
	 * 
	 * @param creditLimit
	 * 
	 * @param processingCharge check validity of Token if it is valid it then will
	 * process the request else it will throw invalid token Exception
	 * 
	 * @return response of String Type
	 * 
	 */

	@GetMapping("/payment/{requestId}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	public String paymentProcessing(@RequestHeader("Authorization") String token,
			@PathVariable("requestId") int requestId, @PathVariable("creditCardNumber") long creditCardNumber,
			@PathVariable("creditLimit") double creditLimit, @PathVariable("processingCharge") double processingcharge)
			throws InvalidTokenException {
		log.info("Started paymentProcessing() method in Component processing Controller");
		try {
			AuthenticationResponse authenticationResponse = null;

			log.info("Authenticating Request Token");
			authenticationResponse = authenticationFeignClient.getValidity(token);
			if (authenticationResponse.isValid()) {
				log.info("JWT Token verified");
			} else {
				log.info("JWT Token Expired");
				throw new InvalidTokenException(invalidTokenExceptionMessage);
			}
		} catch (Exception exception) {
			log.info("Something went wrong in Authentication Microservice");
			log.debug("Exception {} ", exception.getMessage());
			throw new UnknownException(exceptionMessage);
		}

		log.info("Processing Payment Details");
		return paymentService.completeProcessing(requestId, creditCardNumber, creditLimit, processingcharge);
	}
}
