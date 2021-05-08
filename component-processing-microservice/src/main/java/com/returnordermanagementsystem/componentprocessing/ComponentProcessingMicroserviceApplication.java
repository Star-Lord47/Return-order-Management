package com.returnordermanagementsystem.componentprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shivam
 *
 */

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class ComponentProcessingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingMicroserviceApplication.class, args);
	}
}

