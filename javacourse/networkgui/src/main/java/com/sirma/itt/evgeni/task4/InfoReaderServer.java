package com.sirma.itt.evgeni.task4;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

public class InfoReaderServer extends ServerComunicator {

	private ArrayList<DataTransferer> users = new ArrayList<DataTransferer>();

	public InfoReaderServer(ComunicatorListener comunicatorListener) {
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

	@Override
	public void stopConection() {
		super.stopConection();
		for (DataTransferer transferer : users) {
			transferer.closeSocket();
		}
		users.clear();
	}

}
