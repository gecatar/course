package com.sirma.itt.evgeni.task3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SleepingCounterSecond extends Thread {

	private static final Logger LOGGER = Logger
			.getLogger(SleepingCounterSecond.class.getName());
	private int count;
	private static boolean stop;

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
	 * Get value on count.
	 * 
	 * @param count
	 */
	public SleepingCounterSecond(int count) {
		this.count = count;
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
				wait(100);
				decrmentCount();
				LOGGER.log(Level.INFO, this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}