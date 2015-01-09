package com.sirma.itt.evgeni.task4;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class SyncCount extends Thread {

	private static final Logger LOGGER = Logger.getLogger(SyncCount.class
			.getName());
	private static final Object syncher = new Object();
	private int count;

	public SyncCount(int count) {
		this.count = count;
	}

	/**
	 * Get count.
	 */
	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		synchronized (syncher) {
			while (count > 0) {
				count--;
				try {
					LOGGER.log(Level.INFO, this.getName() + " - Count is:"
							+ count);
					syncher.notifyAll();
					syncher.wait();
				} catch (InterruptedException e) {
					LOGGER.log(Level.ERROR, "Counter interupted!!!", e);
				}
			}
			syncher.notifyAll();
		}
	}
}
