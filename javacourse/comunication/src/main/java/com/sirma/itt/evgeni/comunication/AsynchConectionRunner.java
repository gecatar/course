package com.sirma.itt.evgeni.comunication;

/**
 * Open connection asynchronous.
 * 
 * @author GecaTM
 *
 */
public class AsynchConectionRunner extends Thread {

	private final Conector conector;
	private final String ip;
	private final int port;

	/**
	 * Create thread that will start connection.
	 */
	public AsynchConectionRunner(Conector conector, String ip, int port) {
		this.conector = conector;
		this.ip = ip;
		this.port = port;
	}

	/**
	 * Start connection.
	 */
	@Override
	public void run() {
		conector.connect(ip, port);
	}
}
