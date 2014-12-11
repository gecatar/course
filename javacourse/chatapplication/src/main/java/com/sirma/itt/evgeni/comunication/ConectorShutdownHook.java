package com.sirma.itt.evgeni.comunication;

/**
 * Executed when application is closed.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConectorShutdownHook extends Thread {

	Comunicator comunicator;

	public ConectorShutdownHook(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	/**
	 * Stop connection before exit.
	 */
	@Override
	public void run() {
		comunicator.stopConection();
	}
}
