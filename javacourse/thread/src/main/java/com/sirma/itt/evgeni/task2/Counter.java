package com.sirma.itt.evgeni.task2;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Counter thread.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Counter extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Counter.class
			.getName());
	private int countTo;
	private int currentCount = 0;
	private static boolean stop;

	/**
	 * Set value on count.
	 */
	public Counter(int countTo) {
		this.countTo = countTo;
	}

	/**
	 * Tell on threads to stop execution.
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * Get count.
	 * 
	 * @return
	 */
	public int getcount() {
		return currentCount;
	}

	/**
	 * Decrement count.
	 */
	public void incrementCount() {
		currentCount++;
	}

	@Override
	public void run() {
		while (!stop && currentCount < countTo) {
			try {
				sleep(50);
				incrementCount();
				LOGGER.log(Level.DEBUG, this.getName() + " - Count is:"
						+ currentCount);
			} catch (InterruptedException e) {
				LOGGER.log(Level.ERROR, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}