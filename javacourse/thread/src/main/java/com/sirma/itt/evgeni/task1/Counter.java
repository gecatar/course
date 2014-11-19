package com.sirma.itt.evgeni.task1;

/**
 * Counting until user send stop command.
 * @author Evgeni Stefanov
 *
 */
public class Counter extends Thread {

	private int count;
	private boolean stop;

	/**
	 * Used for obtaining current value for count.
	 * @return count.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Stop execution on thread.
	 * @param stop if set to true execution stop.
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * Entry point.
	 */
	public void run() {
		while (!stop) {
			try {
				sleep(100);
				count++;
			} catch (InterruptedException e) {
			}
		}
	}
}