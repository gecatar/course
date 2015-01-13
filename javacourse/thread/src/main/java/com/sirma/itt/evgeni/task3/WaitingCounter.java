package com.sirma.itt.evgeni.task3;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Sleeping counter thread.
 * 
 * @author GecaTM
 *
 */
public class WaitingCounter extends Thread {

	private static final Logger LOGGER = Logger.getLogger(WaitingCounter.class
			.getName());
	private int count;
	private int sleepInterval;
	private boolean stop;

	/**
	 * Get value on count.
	 */
	public WaitingCounter(int count, int sleepInterval) {
		this.count = count;
		this.sleepInterval = sleepInterval;
	}

	/**
	 * Get count.
	 */
	public int getcount() {
		return count;
	}

	/**
	 * Decrement count.
	 */
	public void decrmentCount() {
		count--;
	}

	/**
	 * Start Thread.
	 */
	@Override
	public void run() {
		while (!stop && count > 0) {
			try {
				synchronized (this) {
					wait(sleepInterval);
				}
				decrmentCount();
				LOGGER.log(Level.INFO, this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				LOGGER.log(Level.ERROR, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}