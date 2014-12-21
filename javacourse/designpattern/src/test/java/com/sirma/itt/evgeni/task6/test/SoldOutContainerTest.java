package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.SoldOutContainer;

/**
 * Check adding and removing on sold out items.
 * 
 * @author GecaTM
 *
 */
public class SoldOutContainerTest {

	private SoldOutContainer soldOutContainer;

	/**
	 * Check adding sold out items.
	 */
	@Test
	public void addSoldOutItemTtest() {
		soldOutContainer = new SoldOutContainer();
		soldOutContainer.update('u', "test", 25, null);
		assertEquals("Description:test", soldOutContainer.toString());
	}

	/**
	 * Check removing on sold out items.
	 */
	public void removeSoldOutItemTest() {
		soldOutContainer = new SoldOutContainer();
		soldOutContainer.update('u', "test", 25, null);
		soldOutContainer.update('b', "test", 25, null);
		assertEquals("", soldOutContainer.toString());
	}
}
