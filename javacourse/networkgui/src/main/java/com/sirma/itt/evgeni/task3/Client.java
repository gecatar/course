package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

/**
 * Create connection whit server.
 * 
 * @author GecaTM
 *
 */
public class Client extends ClientComunicator {

	public Client(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Add user session.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		dataTransferer.start();
	}

	/**
	 * Receive message from server.
	 */
	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage(message);
		stopConection();
		comunicatorListener.setConectionStatus(false);
	}

}
