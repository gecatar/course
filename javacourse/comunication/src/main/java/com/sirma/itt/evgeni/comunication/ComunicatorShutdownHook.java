package com.sirma.itt.evgeni.comunication;

/**
 * Close communicator when application is closed.
 * 
 * @author GecaTM
 *
 */
public class ComunicatorShutdownHook extends Thread {

	private Comunicator comunicator;

	/**
	 * Set communicator.
	 */
	public ComunicatorShutdownHook(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	/**
	 * Start closing.
	 */
	@Override
	public void run() {
		comunicator.close();
	}
}
