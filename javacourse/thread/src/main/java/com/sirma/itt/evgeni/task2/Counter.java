package com.sirma.itt.evgeni.task2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Counter thread.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Counter extends Thread {

	private static final Logger LOGGER = Logger.getLogger(Counter.class
			.getName());
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
	public Counter(int count) {
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
				sleep(50);
				decrmentCount();
				LOGGER.log(Level.INFO, this.getName() + " - Count is:" + count);
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Trhead interupted.", e);
			}
		}
		stop = true;
	}
}