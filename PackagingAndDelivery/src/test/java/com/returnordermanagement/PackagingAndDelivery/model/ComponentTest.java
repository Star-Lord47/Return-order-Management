package com.returnordermanagement.PackagingAndDelivery.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.returnordermanagement.packaginganddelivery.model.Component;

import lombok.extern.slf4j.Slf4j;


/*
 * This class is used to test whether setter,getter,To string, Constructor given the expected result. 
 */
@RunWith(SpringRunner.class)
@Slf4j
public class ComponentTest {
	@Mock
	private Component component;

	@Before
	public void setup() {
		log.info("Start");
		component =new Component();
		component.setComponentType("Accessory");
		component.setCount(5);
		log.info("End");
	}

	@Test
	public void testComponentDetails() throws Exception {
		log.info("Start");
		assertEquals("Accessory", component.getComponentType());
		assertEquals(5, component.getCount());
		log.info("End");

	}

	@Test
	public void testAllArgsConstructor() {

		Component component = new Component("Integral", 15);
		assertEquals("Integral", component.getComponentType());
	}

	@Test
	public void testToStringMethod() {
		log.info("Start");
		assertEquals(component.toString(), component.toString());
		log.info("End");
	}

	@Test
	public void testSetters() {
		component.setCount(50);
		assertEquals(50, component.getCount());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = component.equals(component);
		assertTrue(equals);
	}

	/**
	 * Tests the hashCode() method
	 */
	@Test
	public void testHashCodeMethod() {
		int hashCode = component.hashCode();
		assertEquals(hashCode, component.hashCode());
	}
}
