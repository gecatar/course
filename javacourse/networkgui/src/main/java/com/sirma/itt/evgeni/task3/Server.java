package com.sirma.itt.evgeni.task3;

/**
 * Create conection whit client and send message.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Server {

	ServerConector serverConector;

	public Server() {
	}

	/**
	 * Start connection whit client.
	 * 
	 * @param ip
	 * @param port
	 */
	public void startConection(String ip, int port) {
		if (serverConector == null) {
			serverConector = new ServerConector(ip, port);
			serverConector.start();
		}
	}

	/**
	 * Stop receiving on new clients.
	 */
	public synchronized void stopConection() {
		if (serverConector != null) {
			serverConector.closeSocket();
			serverConector = null;
		}
	}
}
