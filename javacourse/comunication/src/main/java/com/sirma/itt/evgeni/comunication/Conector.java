package com.sirma.itt.evgeni.comunication;

public abstract class Conector extends Thread {

	protected Comunicator comunicator;
	private boolean conecting;

	public Conector(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	public void startConection(String ip, int port) {
		if (!conecting) {
			conecting = true;
			new AssynchConectionRunner(this, ip, port).start();
		}
	}

	public void stopConection() {
		if (conecting) {
			conecting = false;
			disconect();
		}
	}

	protected abstract void connect(String ip, int port);

	protected abstract void disconect();

}
