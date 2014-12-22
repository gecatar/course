package com.sirma.itt.evgeni.task3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sleeping counter thread.
 * 
 * @author GecaTM
 *
 */
public class SleepingCounterSecond extends Thread {

	private static final Logger LOGGER = Logger
			.getLogger(SleepingCounterSecond.class.getName());
	private int count;
	private int sleepInterval;
	private static boolean stop;

	/**
	 * Get value on count.
	 * 
	 * @param count
	 */
	public SleepingCounterSecond(int count, int sleepInterval) {
		this.count = count;
		this.sleepInterval = sleepInterval;
	}

	/**
	 * Tell on threads to stop execution.
	 * 
	 * @param stop
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
				wait(sleepInterval);
				decrmentCount();
				LOGGER.log(Level.INFO, this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}