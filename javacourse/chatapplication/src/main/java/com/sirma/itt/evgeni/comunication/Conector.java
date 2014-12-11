package com.sirma.itt.evgeni.comunication;

/**
 * Allow creating connections between Communicators.
 * 
 * @author Evgeni Stefanov
 * 
 */
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

	@Override
	public abstract void run();

	/**
	 * Set recourses that will be closed when object is disposed.
	 * 
	 * @param autoClosable
	 */
	public abstract void setAutoclosable(AutoCloseable autoClosable);

	/**
	 * Close connection.
	 */
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
