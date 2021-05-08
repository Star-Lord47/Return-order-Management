package com.returnordermanagementsystem.componentprocessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.returnordermanagementsystem.componentprocessing.feignclient.PaymentFeignClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

	@Autowired
	PaymentFeignClient paymentFeignClient;

	@Value("${exception.message}")
	private String exceptionMessage;

	/*
	 * This method accepts the following as parameters and process the request
	 * 
	 * @param requestId
	 * 
	 * @param creditCardNumber
	 * 
	 * @param creditLimit
	 * 
	 * @param processingCharge Internally it will call the payment microservice and
	 * microservice will return the current balance If reponse returned is -1 or
	 * less then request cannot be processed else process the request
	 * 
	 * @return response of String Type
	 * 
	 */

	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		log.info("START completeProcessing() method in Payment Service ");
		double currentBalance = 0;
		String response = null;

		log.info("Calling Payment Microservice");
		currentBalance = paymentFeignClient.getCurrentBalance(creditCardNumber, processingCharge);

		if (currentBalance <= -1) {
			response = "Your payment could not be processed due to Insufficient Funds.";
		} else {
			response = "Payment Successful.Thank you for using our Service";
		}
		log.debug("Response sent--> {}", response);

		return response;
	}
}
