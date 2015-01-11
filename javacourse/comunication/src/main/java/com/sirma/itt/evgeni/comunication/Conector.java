package com.sirma.itt.evgeni.comunication;

public abstract class Conector {

	protected Comunicator comunicator;
	private boolean conecting;

	public Conector(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	public boolean startConection(String ip, int port) {
		if (!conecting) {
			conecting = true;
			new AssynchConectionRunner(this, ip, port).start();
			return true;
		}
		return false;
	}

	public boolean stopConection() {
		if (conecting) {
			conecting = false;
			disconect();
			return true;
		}
		return false;
	}

	protected abstract void connect(String ip, int port);

	protected void disconect() {
		conecting = false;
	}

}
