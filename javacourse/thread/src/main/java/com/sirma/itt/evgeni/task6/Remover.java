package com.sirma.itt.evgeni.task6;

/**
 * Call function for removing unused objects in last session.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Remover extends Thread {

	private final TimeOutTable table;
	private final int interval;
	private boolean stop;

	/**
	 * Allow thread to be stooped safely.
	 * 
	 * @param stop
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public Remover(TimeOutTable table, int interval) {
		this.table = table;
		this.interval = interval;
	}

	/**
	 * Regular call function that delete unused objects.
	 */
	@Override
	public void run() {

		while (!stop) {
			try {
				table.lockRemover();
				sleep(interval);
				table.removeUnused();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}