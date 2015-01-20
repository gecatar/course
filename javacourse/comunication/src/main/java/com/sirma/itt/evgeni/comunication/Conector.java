package com.sirma.itt.evgeni.comunication;

/**
 * Start connection.
 * 
 * @author GecaTM
 *
 */
public abstract class Conector {

	protected Comunicator comunicator;
	private boolean conecting;

	/**
	 * Set communicator.
	 */
	public Conector(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	/**
	 * Start connection.
	 */
	public boolean startConection(String ip, int port) {
		if (!conecting) {
			conecting = true;
			new AsynchConectionRunner(this, ip, port).start();
			return true;
		}
		return false;
	}

	/**
	 * Stop connection.
	 */
	public boolean stopConection() {
		if (conecting) {
			conecting = false;
			disconect();
			return true;
		}
		return false;
	}

	/**
	 * Execute connecting code.
	 */
	protected abstract void connect(String ip, int port);

	protected void disconect() {
		conecting = false;
	}

}
