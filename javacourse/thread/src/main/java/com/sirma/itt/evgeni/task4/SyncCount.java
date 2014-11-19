package com.sirma.itt.evgeni.task4;

/**
 * Using helper object to synchronize execution on every thread.
 * @author Evgeni Stefanov
 *
 */
public class SyncCount extends Thread {

	private static Synchronizator synchronizator = new Synchronizator();
	private int count;
	private boolean syncOn;

	/**
	 * Determine on which cycle thread will be updated.
	 * @param count
	 * @param syncOn tell on thread when to update itself.
	 */
	public SyncCount(int count, boolean syncOn) {
		this.syncOn = syncOn;
		this.count = count;
	}

	public void run() {
		while (count > 0) {
			if (synchronizator.isSyncReady(syncOn)) {
				synchronized(this){
					count--;
					System.out.println(this.getName()+":"+count);
				}
				synchronizator.changeState();
			} else {
				synchronizator.lock();
			}
		}
	}
}