package com.sirma.itt.evgeni.task3;

/**
 * Create thread.
 * 
 * @author root
 *
 */
public class WaitRunner {

	/**
	 * Start thread.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WaitingCounter waitingCounter = new WaitingCounter(20, 200);
		waitingCounter.start();
	}

}
