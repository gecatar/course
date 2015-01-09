package com.sirma.itt.evgeni.comunication;

public class ConectorShutdownHook extends Thread {

	private Comunicator comunicator;

	public ConectorShutdownHook(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	@Override
	public void run() {
		comunicator.close();
	}
}
