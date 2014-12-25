package com.sirma.itt.evgeni.comunication;

public abstract class Conector extends Thread {

	protected Comunicator comunicator;
	protected String ipAdress;
	protected int port;

	public Conector(Comunicator comunicator, String ipAdress, int port) {
		this.comunicator = comunicator;
		this.ipAdress = ipAdress;
		this.port = port;
	}

	public abstract void conect();

	public abstract void closeConector();

	@Override
	public void run() {
		conect();
	}
}
