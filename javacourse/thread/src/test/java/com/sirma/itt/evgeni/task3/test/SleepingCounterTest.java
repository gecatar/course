package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.SleepingCounter;

/**
 * Check stop counting function.
 * 
 * @author GecaTM
 *
 */
public class SleepingCounterTest {

	@Test(timeout = 2000)
	public void test() {
		SleepingCounter firstCounter = new SleepingCounter(9, 50);
		SleepingCounter secondCounter = new SleepingCounter(3, 50);
		firstCounter.start();
		secondCounter.run();
		assertEquals(0, secondCounter.getcount());
	}

}
