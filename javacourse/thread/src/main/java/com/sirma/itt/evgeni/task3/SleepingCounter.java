package com.sirma.itt.evgeni.task3;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SleepingCounter extends Thread {

	private static final Logger LOGGER = Logger.getLogger(SleepingCounter.class
			.getName());
	private int count;
	private int sleepInterval;
	private static boolean stop;

	/**
	 * Set value on count and sleep interval.
	 * 
	 * @param count
	 */
	public SleepingCounter(int count, int sleepInterval) {
		this.count = count;
		this.sleepInterval = sleepInterval;
	}

	/**
	 * Tell on threads to stop execution.
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
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

	@Override
	public void run() {
		while (!stop && count > 0) {
			try {
				sleep(sleepInterval);
				decrmentCount();
				LOGGER.log(Level.INFO, this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				LOGGER.log(Level.ERROR, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}
