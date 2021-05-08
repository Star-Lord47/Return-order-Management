package com.returnordermanag.authorizationService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.returnordermanagement.authorizationService.Repository.UserRepository;
import com.returnordermanagement.authorizationService.model.MyUser;
import com.returnordermanagement.authorizationService.service.MyUserDetailsService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MyUserDetailsServiceTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@InjectMocks
	MyUserDetailsService myUserDetailService;

	@Mock
	UserRepository userRepository;

	/**
	 * to test the test_loadUserByUsername()
	 */
	@Test
	void test_loadUserByUsernameTest() {

		MyUser user = new MyUser("1", "Shivam", "shivam");
		when(userRepository.findByUsername("Shivam")).thenReturn(user);
		UserDetails loadUserByUsername = myUserDetailService.loadUserByUsername("Shivam");
		assertEquals(user.getUsername(), loadUserByUsername.getUsername());
	}

}
