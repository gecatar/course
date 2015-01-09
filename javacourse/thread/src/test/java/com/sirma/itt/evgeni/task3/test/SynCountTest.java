package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task4.SyncCount;

/**
 * Test correct counting.
 * 
 * @author root
 *
 */
public class SynCountTest {

	/**
	 * Test correct counting.
	 */
	@Test
	public void syncCountTest() throws InterruptedException {
		SyncCount firstCount = new SyncCount(5);
		SyncCount secondCount = new SyncCount(5);
		firstCount.start();
		secondCount.start();
		firstCount.join();
		secondCount.join();
		assertEquals(0, firstCount.getCount());
		assertEquals(0, secondCount.getCount());
	}

}
