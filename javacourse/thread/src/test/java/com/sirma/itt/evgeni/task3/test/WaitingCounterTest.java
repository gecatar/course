package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.WaitingCounter;

/**
 * Check stop counting function.
 * 
 * @author GecaTM
 *
 */
public class WaitingCounterTest {

	@Test(timeout = 2000)
	public void test() {
		WaitingCounter firstCounter = new WaitingCounter(9, 50);
		WaitingCounter secondCounter = new WaitingCounter(3, 50);
		firstCounter.start();
		secondCounter.run();
		assertEquals(0, secondCounter.getcount());
	}

}