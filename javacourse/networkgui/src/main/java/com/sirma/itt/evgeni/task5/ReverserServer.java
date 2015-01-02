package com.sirma.itt.evgeni.task5;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

public class ReverserServer extends ServerComunicator {

	private ArrayList<DataTransferer> users = new ArrayList<DataTransferer>();

	public ReverserServer(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		users.add(dataTransferer);
		dataTransferer.start();
		comunicatorListener.displayMessage("New user conected to server.");
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		if (users.contains(dataTransferer)) {
			users.remove(dataTransferer);
			dataTransferer.closeSocket();
			comunicatorListener.displayMessage("User disconected from server.");
		}
	}

	private String reverseMessage(String message) {
		return new StringBuilder(message).reverse().toString();
	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		transferer.sendData(reverseMessage(message));
	}

	@Override
	public void stopConection() {
		super.stopConection();
		for (DataTransferer transferer : users) {
			transferer.closeSocket();
		}
		users.clear();
	}

}
