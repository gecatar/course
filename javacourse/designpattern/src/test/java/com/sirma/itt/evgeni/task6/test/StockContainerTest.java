package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.StockContainer;

/**
 * Check adding and removing items from store.
 * 
 * @author GecaTM
 *
 */
public class StockContainerTest {

	StockContainer stockContainer;

	/**
	 * Checking adding items.
	 */
	@Test
	public void addQuantityTtest() {
		stockContainer = new StockContainer();
		stockContainer.update('b', "test", 10, null);
		assertEquals("Description:test Quantity:10", stockContainer.toString());
	}

	/**
	 * Check correct removing on items.
	 */
	public void removeQuantityTest() {
		stockContainer = new StockContainer();
		stockContainer.update('b', "test", 10, null);
		stockContainer.update('s', "test", 5, null);
		assertEquals("Description:test Quantity:5", stockContainer.toString());
	}

}
