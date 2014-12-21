package com.sirma.itt.evgeni.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Counting until user send stop command.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Counter extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Counter.class
			.getName());
	private int count;
	private boolean stop;

	/**
	 * Used for obtaining current value for count.
	 * 
	 * @return count.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Stop execution on thread.
	 * 
	 * @param stop
	 *            if set to true execution stop.
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * Increment count.
	 */
	public void incrementCount() {
		count++;
	}

	/**
	 * Entry point.
	 */
	@Override
	public void run() {
		while (!stop) {
			try {
				sleep(10);
				incrementCount();
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupted", e);
			}
		}
	}
}