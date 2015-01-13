package com.sirma.itt.evgeni.task5;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

/**
 * Receive and reverse messages.
 * 
 * @author GecaTM
 *
 */
public class ReverserServer extends ServerComunicator {

	private ArrayList<DataTransferer> users = new ArrayList<DataTransferer>();

	public ReverserServer(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Add user session.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		users.add(dataTransferer);
		dataTransferer.start();
		comunicatorListener.displayMessage("New user conected to server.");
	}

	/**
	 * Close user session.
	 */
	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		if (users.contains(dataTransferer)) {
			users.remove(dataTransferer);
			dataTransferer.closeSocket();
			comunicatorListener.displayMessage("User disconected from server.");
		}
	}

	/**
	 * Reverse message.
	 */
	private String reverseMessage(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	/**
	 * Receive messages.
	 */
	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		transferer.sendData(reverseMessage(message));
	}

	/**
	 * Stop conection.
	 */
	@Override
	public void stopConection() {
		super.stopConection();
		for (DataTransferer transferer : users) {
			transferer.closeSocket();
		}
		users.clear();
	}

}
