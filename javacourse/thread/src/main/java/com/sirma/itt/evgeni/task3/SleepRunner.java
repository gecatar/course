package com.sirma.itt.evgeni.task3;

/**
 * Create thread.
 * 
 * @author root
 *
 */
public class SleepRunner {

	/**
	 * Start thread.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SleepingCounter sleepingCounter = new SleepingCounter(4, 100);
		sleepingCounter.start();
	}

}
