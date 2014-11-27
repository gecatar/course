package com.sirma.itt.evgeni.comunication;

public abstract class Conector extends Thread {

	protected Comunicator comunicator;
	protected AutoCloseable autoclosableSocket;
	protected String ipAdress;
	protected int port;

	public Conector(Comunicator comunicator, String ipAdress, int port) {
		this.comunicator = comunicator;
		this.ipAdress = ipAdress;
		this.port = port;
	}

	public abstract void setAutoclosable(AutoCloseable autoClosable);

	public synchronized void stopConector() {
		try {
			if (autoclosableSocket != null) {
				autoclosableSocket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
