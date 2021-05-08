package com.returnordermanag.authorizationService.util;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.returnordermanagement.authorizationService.Repository.UserRepository;
import com.returnordermanagement.authorizationService.util.JwtUtil;

import io.jsonwebtoken.Claims;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class JwtUtilTest {

	UserDetails userDetails;

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@InjectMocks
	JwtUtil jwtUtil;

	@Mock
	UserRepository userRepository;

	@Mock
	Claims claim;

	/**
	 * to test the generation of a token
	 */
	@Test
	void test_generateTokenTest() {
		userDetails = new User("Shivam", "shivam", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		assertNotNull(generateToken);
	}

	/**
	 * to test the validateToken()
	 */
	@Test
	void test_validateTokenTest() {
		userDetails = new User("Shivam", "shivam", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	/**
	 * to test the validate token by name
	 */
	@Test
	void test_validateTokenWithNameTest() {
		userDetails = new User("Shivam", "shivam", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

	@Test
	void tokenExpirationTest() {
		userDetails = new User("Shivam", "shivam", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Date expire = jwtUtil.extractExpiration(generateToken);
		Date actual = new Date(System.currentTimeMillis());
		assertTrue(expire.getTime() > actual.getTime());

	}

}
