package com.sirma.itt.evgeni.comunication;

/**
 * Open connection asynchronous.
 * 
 * @author GecaTM
 *
 */
public class AsynchConectionRunner extends Thread {

	private final Comunicator comunicator;
	private final String ip;
	private final int port;

	/**
	 * Create thread that will start connection.
	 */
	public AsynchConectionRunner(Comunicator comunicator, String ip, int port) {
		this.comunicator = comunicator;
		this.ip = ip;
		this.port = port;
	}

	/**
	 * Start connection.
	 */
	@Override
	public void run() {
		comunicator.connect(ip, port);
	}
}
