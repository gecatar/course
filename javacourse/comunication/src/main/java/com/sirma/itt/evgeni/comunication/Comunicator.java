package com.sirma.itt.evgeni.comunication;

/**
 * Used for sending and receiving messages.
 * 
 * @author GecaTM
 *
 */
public abstract class Comunicator {

	protected Conector conector;
	protected ComunicatorListener listener;
	protected String name;

	public Comunicator(ComunicatorListener listener) {
		this.listener = listener;
	}

	/**
	 * Start connection and notify listener.
	 */
	public void startConection(String ip, int port) {
		if (conector.startConection(ip, port)) {
			listener.setConectionStatus(MesageCommand.COMUNICATOR_CONECTING);
		}
	}

	/**
	 * Stop connection and notify listener.
	 */
	public void stopConection() {
		if (conector.stopConection()) {
			listener.setConectionStatus(MesageCommand.COMUNICATOR_DISCONECTED);
			close();
		}
	}

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
	 * Send message.
	 */
	public abstract void sendMessage(String name, String text);

	/**
	 * Set communicator name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Close communicator resources.
	 */
	public void close() {

	}

}
