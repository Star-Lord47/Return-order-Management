package com.returnordermanagement.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 * 
 * @author Manish
 * 
 * */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@Slf4j
public class PaymentServiceApplication {

	public static void main(String[] args) {
		log.info("In Main");
		SpringApplication.run(PaymentServiceApplication.class, args);
		
	}
	

}
