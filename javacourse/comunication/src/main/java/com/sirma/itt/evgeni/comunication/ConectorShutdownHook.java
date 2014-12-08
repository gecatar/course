package com.sirma.itt.evgeni.comunication;

public class ConectorShutdownHook extends Thread {

	Comunicator comunicator;

	public ConectorShutdownHook(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	@Override
	public void run() {
		comunicator.stopConection();
		System.out.println("Conector stopped....!!!@#@!#!@#!@#@!");
	}
}
