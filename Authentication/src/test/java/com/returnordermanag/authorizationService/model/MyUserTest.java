package com.returnordermanag.authorizationService.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.returnordermanagement.authorizationService.model.MyUser;

class MyUserTest {
	MyUser myUser = new MyUser();

	@Test
	void testGetUserId() {
		myUser.setUserid("1");
		assertEquals("1", myUser.getUserid());
	}

	@Test
	void testGetUsername() {
		myUser.setUsername("Shivam");
		assertEquals("Shivam", myUser.getUsername());
	}

	@Test
	void testGetPassword() {
		myUser.setPassword("shivam");
		assertEquals("shivam", myUser.getPassword());
	}

	@Test
	void testConstructor() {
		MyUser myUser = new MyUser("1", "Shivam", "shivam");
		assertNotNull(myUser.getUserid());
		assertEquals("Shivam", myUser.getUsername());
		assertEquals("shivam", myUser.getPassword());
	}

}
