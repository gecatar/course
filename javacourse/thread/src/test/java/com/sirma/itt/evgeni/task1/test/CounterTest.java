package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.evgeni.task1.Counter;

/**
 * Test incrementing count and set stop command.
 * 
 * @author GecaTM
 *
 */
public class CounterTest {

	/**
	 * Test set stop command.
	 */
	@Test
	public void setStopTest() {
		Counter counter = new Counter();
		counter.setStop(true);
		counter.run();
		assertTrue(counter.getCount() == 0);
	}

	/**
	 * Test increment count.
	 * 
	 * @throws InterruptedException
	 */
	@Test(timeout = 250)
	public void incrementCountTest() throws InterruptedException {
		Counter counter = new Counter();
		counter.start();
		Thread.sleep(120);
		counter.setStop(true);
		assertTrue(counter.getCount() > 0);
	}

}
