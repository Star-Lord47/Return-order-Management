package com.returnordermanagement.PackagingAndDelivery.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.returnordermanagement.packaginganddelivery.exception.ComponentTypeNotFound;

/*
 * This class is used to test whether ComponentTypeNotFound Exception show the proper result or not
 */
public class ComponentTypeNotFoundTest {

	@Test
	public void testOneArgConstructor() {
		ComponentTypeNotFound exception = new ComponentTypeNotFound("Invalid Component Type");
		assertEquals("Invalid Component Type", exception.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		ComponentTypeNotFound exception = new ComponentTypeNotFound();
		assertEquals(null, exception.getMessage());
	}
}
