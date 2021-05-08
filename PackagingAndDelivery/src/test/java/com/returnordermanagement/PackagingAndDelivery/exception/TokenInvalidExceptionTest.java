package com.returnordermanagement.PackagingAndDelivery.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanagement.packaginganddelivery.exception.TokenInvalidException;

/*
 * This class is used to test whether ComponentTypeNotFound Exception show the proper result or not
 */
@SpringBootTest
public class TokenInvalidExceptionTest {
	

	@Test
	public void testOneArgConstructor() {
		TokenInvalidException tokenNotValid = new TokenInvalidException("Token validaton failed.");
		assertEquals("Token validaton failed.", tokenNotValid.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		TokenInvalidException tokenNotValid = new TokenInvalidException();
		assertEquals(null, tokenNotValid.getMessage());
	}


}
