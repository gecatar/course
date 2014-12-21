package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.evgeni.task2.Counter;

/**
 * Check correct stooping on threads when they finish work.
 * 
 * @author GecaTM
 *
 */
public class TwoCounterThreadTest {

	/**
	 * Check setStop.
	 */
	@Test
	public void stopTest() {
		Counter firstCcounter = new Counter(20);
		Counter secondCounter = new Counter(10);
		firstCcounter.start();
		secondCounter.run();
		assertTrue(secondCounter.getcount() == 0);
	}

}
