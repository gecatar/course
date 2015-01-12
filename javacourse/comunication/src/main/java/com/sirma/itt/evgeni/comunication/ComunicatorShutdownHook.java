package com.sirma.itt.evgeni.comunication;

public class ComunicatorShutdownHook extends Thread {

	private Comunicator comunicator;

	public ComunicatorShutdownHook(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	@Override
	public void run() {
		comunicator.close();
	}
}
