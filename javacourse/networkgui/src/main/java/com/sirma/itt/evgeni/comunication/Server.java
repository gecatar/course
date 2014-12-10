package com.sirma.itt.evgeni.comunication;

import java.net.ServerSocket;

public class Server extends Thread {

	protected ServerSocket serverSocket;
	protected String ipAdress;
	protected int port;
	protected ComunicatorListener listener;

	public Server(String ipAdress, int port, ComunicatorListener listener) {
		this.ipAdress = ipAdress;
		this.port = port;
		this.listener = listener;
	}

	public void closeResources(AutoCloseable autoCloseable) {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
