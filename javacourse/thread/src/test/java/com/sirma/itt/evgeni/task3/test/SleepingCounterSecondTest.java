package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.SleepingCounterSecond;

/**
 * Check stop counting function.
 * 
 * @author GecaTM
 *
 */
public class SleepingCounterSecondTest {

	@Test(timeout = 2000)
	public void test() {
		SleepingCounterSecond firstCounter = new SleepingCounterSecond(9, 50);
		SleepingCounterSecond secondCounter = new SleepingCounterSecond(3, 50);
		firstCounter.start();
		secondCounter.run();
		assertEquals(0, secondCounter.getcount());
	}

}