package com.returnordermanag.authorizationService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

//import com.cognizant.auth.AuthorizationMicroserviceApplication;
import com.returnordermanagement.authorizationService.JwtAuthenticationApplication;

/**
 * 
 * @author bhargav vaikunta
 *
 */
@SpringBootConfiguration
@SpringBootTest
class JwtAuthenticationApplicationTests {

	@Test
	void contextLoads() {
	}
	
	/**
	 * Testing the Main Class
	 */
	@Test
	void applicationStarts() {
		JwtAuthenticationApplication.main(new String[] {});
	}

	


}
