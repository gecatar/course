package com.sirma.itt.evgeni.task7.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task7.Store;

/**
 * Test adding and removing stock from store.
 * 
 * @author GecaTM
 *
 */
public class StoreTest {

	Store store;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Check adding stock to store.
	 */
	@Test
	public void addStockTest() {
		store = new Store(100);
		store.buyStock("test", 15);
		assertEquals("Description:test Quantity:15", store.toString());
	}

	/**
	 * Check removing stock from store.
	 */
	@Test
	public void removeStockTest() {
		store = new Store(100);
		store.buyStock("test", 15);
		store.sellStock("test", 10);
		assertEquals("Description:test Quantity:5", store.toString());
	}

}
