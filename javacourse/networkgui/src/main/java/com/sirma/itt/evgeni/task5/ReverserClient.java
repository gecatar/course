package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

/**
 * Read reversed messages.
 * 
 * @author GecaTM
 *
 */
public class ReverserClient extends ClientComunicator {

	private DataTransferer dataTransferer;

	public ReverserClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Add user session.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(true);
		this.dataTransferer = dataTransferer;
		dataTransferer.start();
	}

	/**
	 * Close user session.
	 */
	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(false);
		closeConector();
	}

	/**
	 * Receive messages.
	 */
	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage("Reversed message:" + message);
	}

	/**
	 * Send messages.
	 */
	@Override
	public void sendMessage(String message) {
		if (dataTransferer != null) {
			dataTransferer.sendData(message);
		}
	}
}
