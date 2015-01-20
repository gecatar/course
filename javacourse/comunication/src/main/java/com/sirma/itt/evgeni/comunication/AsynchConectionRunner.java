package com.sirma.itt.evgeni.comunication;

public class AsynchConectionRunner extends Thread {

	private final Conector conector;
	private final String ip;
	private final int port;

	public AsynchConectionRunner(Conector conector, String ip, int port) {
		this.conector = conector;
		this.ip = ip;
		this.port = port;
	}

	@Override
	public void run() {
		conector.connect(ip, port);
	}
}
