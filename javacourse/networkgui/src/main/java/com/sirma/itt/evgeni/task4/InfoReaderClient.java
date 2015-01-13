package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

/**
 * Read information about clients.
 * 
 * @author GecaTM
 *
 */
public class InfoReaderClient extends ClientComunicator {

	public InfoReaderClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Receive messages.
	 */
	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage(message);
	}

	/**
	 * Add user sessions.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(true);
		dataTransferer.start();
	}

	/**
	 * Close user sessions.
	 */
	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		stopConection();
		comunicatorListener.setConectionStatus(false);
	}
}
