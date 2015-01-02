package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.SoldContainer;

/**
 * Test correct collecting on sold information.
 * 
 * @author GecaTM
 *
 */
public class SoldContainerTest {

	SoldContainer soldContainer;

	/**
	 * Check registering on sales.
	 */
	@Test
	public void registerSaleTtest() {
		soldContainer = new SoldContainer();
		soldContainer.update('s', "test", 10, null);
		assertEquals("Sold container:\nDescription:test Quantity:10",
				soldContainer.toString());
	}

	/**
	 * Check correct roll back sales.
	 */
	@Test
	public void rollBackSaleTest() {
		soldContainer = new SoldContainer();
		soldContainer.update('s', "test", 10, null);
		soldContainer.update('u', "test", 5, null);
		assertEquals("Sold container:\nDescription:test Quantity:5",
				soldContainer.toString());
	}

}
