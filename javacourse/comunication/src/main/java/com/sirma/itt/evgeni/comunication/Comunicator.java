package com.sirma.itt.evgeni.comunication;

/**
 * Used for sending and receiving messages.
 * 
 * @author GecaTM
 *
 */
public abstract class Comunicator {

	protected String name;

	public abstract void connect(String ip, int port);

	public abstract void stopConnection();

	/**
	 * Start data transferrer.
	 */
	public void openSession(DataTransferer dataTransferer) {
		dataTransferer.start();
	}

	/**
	 * Process message.
	 */
	public abstract void processMesage(Mesage mesage,
			DataTransferer dataTransferer);

	/**
	 * Close data transferrer.
	 */
	public void closeSession(DataTransferer dataTransferer) {
		dataTransferer.closeSocket();
	}

	/**
	 * Set communicator name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Close communicator resources.
	 */
	public abstract void close();

}
