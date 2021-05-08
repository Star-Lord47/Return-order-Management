package com.returnordermanagement.returnorderportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.returnordermanagement.returnorderportal.client.ComponentProcessingFeignClient;
import com.returnordermanagement.returnorderportal.model.ProcessRequest;
import com.returnordermanagement.returnorderportal.model.ProcessResponse;
import com.returnordermanagement.returnorderportal.model.User;
import com.returnordermanagement.returnorderportal.repository.ProcessReponseRepository;
import com.returnordermanagement.returnorderportal.repository.ProcessRequestRepository;
import com.returnordermanagement.returnorderportal.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/*
 * @author Manan
 */
@Controller
@Slf4j
public class ProcessController {
	@Autowired
	User user;
	/*
	 * ProcessRequest Consist of component name and number of defective
	 */
	@Autowired
	ProcessRequest processRequest;
	/*
	 * data from componentProcessingFeignClient is been stored in this class object
	 */
	@Autowired
	ProcessResponse processResponse;
	/*
	 * The username and password with token is been searched in the database
	 */
	@Autowired
	UserRepository userRepo;
	/*
	 * Request sent from ui is been saved in process processRequestRepository.
	 */
	@Autowired
	ProcessRequestRepository processRequestRepository;
	/*
	 * Request received from microservice saved in processResponseRepository.
	 */
	@Autowired
	ProcessReponseRepository processResponseRepository;
	/*
	 * Request sent/ recieved to component componentProcessingFeignClient
	 */
	@Autowired
	ComponentProcessingFeignClient componentProcessingFeignClient;
	@Value("${payment-message}")
	private String paymentMessage;

	@RequestMapping("/addprocessRequest") // To be invoked when user enters component details
	public String displayProcessingDetails(@RequestParam("username") String username,
			@RequestParam("contactNumber") long contactNumber, @RequestParam("componentType") String componentType,
			@RequestParam("componentName") String componentName,
			@RequestParam("quantityOfDefective") int quantityOfDefective,
			@RequestParam(value = "isPriorityRequest", required = false) boolean isPriorityRequest, Model model) {
		log.info("Handling /addProcessRequest");

		long creditCardNumber = 1;
		processRequest = new ProcessRequest(1, username, contactNumber, creditCardNumber, componentType, componentName,
				quantityOfDefective, isPriorityRequest);
		processRequestRepository.save(processRequest);
		String jwtToken = "Bearer " + userRepo.findById(processRequest.getUserId()).get().getJwtToken();

		log.info("Component processing MicroService :: Package and Delivery");
		processResponse = componentProcessingFeignClient.getProcessingDetails(jwtToken, processRequest);
		processResponseRepository.save(processResponse);

		// Below fields to be displayed in process.jsp
		int requestId = processResponse.getRequestId();
		int userID = processResponse.getUserId();
		double processingCharge = processResponse.getProcessingCharge();
		double packagingAndDeliveryCharge = processResponse.getPackagingAndDeliveryCharge();
		String dateOfDelivery = processResponse.getDateOfDelivery().toString();
		model.addAttribute("username", user.getUsername());
		model.addAttribute("requestId", requestId);
		model.addAttribute("userID", userID);
		model.addAttribute("processingCharge", processingCharge);
		model.addAttribute("packagingAndDeliveryCharge", packagingAndDeliveryCharge);
		model.addAttribute("dateOfDelivery", dateOfDelivery);
		model.addAttribute("componentName", componentName);

		return "process.jsp";
	}

	/*
	 * In process.jsp shows the details about payment to be done
	 */
	@RequestMapping("/cardDetails")
	public String paymentgateway(Model model) {
		log.info("Handling /cardDetails");
		log.info("Component processing MicroService :: Payment Microservice");
		model.addAttribute("username", user.getUsername());
		log.info("in card");
		return "payment.jsp";
	}

	/*
	 * In payment.jsp ask for the card details regarding card number If card number
	 * is valid and it has balance > the ammount to be debited ->Payment Success
	 * else Payment Failed
	 */
	@RequestMapping("/payment")
	public String confirmationMessage(@RequestParam("creditCardNumber") long userCardNumber, Model model) {

		log.info("Handling /payment request");
		processRequest.setCreditCardNumber(userCardNumber);
		String response = "";
		String jwtToken = "Bearer " + userRepo.findById(processRequest.getUserId()).get().getJwtToken();
		int requestID = processResponse.getRequestId();
		long creditCardNumber = processRequest.getCreditCardNumber();
		double totalCharge = processResponse.getProcessingCharge() + processResponse.getPackagingAndDeliveryCharge();
		response = componentProcessingFeignClient.paymentProcessing(jwtToken, requestID, creditCardNumber, 2000.0,
				totalCharge);
		log.info("Component processing MicroService :: Payment Microservice");
		try {
			log.debug("Exception in Payment Microservice", creditCardNumber);
			String componentName = processRequest.getComponentName();
			String username = processRequest.getUserName();
			long creditCarNumber = processRequest.getCreditCardNumber();
			String displayCard = Long.toString(creditCarNumber).substring(0, 4) + "xxxxxxxxxxxx";
			double charge = processResponse.getPackagingAndDeliveryCharge() + processResponse.getProcessingCharge();
			model.addAttribute("requestId", processResponse.getRequestId());
			model.addAttribute("response", response);
			model.addAttribute("componentName", componentName);
			model.addAttribute("username", username);
			model.addAttribute("creditCardNumber", displayCard);
			model.addAttribute("charge", charge);
			if (response.equals(paymentMessage))
				return "success.jsp";
		} catch (Exception e) {
			log.info("InValid Card No :: CardNo not present in database ");
			return "failed.jsp";
		}
		log.info("Payment failed :: Insufficent Fund");
		return "failed.jsp";
	}
}
