package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class InfoReaderClient extends ClientComunicator {

	public InfoReaderClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage(message);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(true);
		dataTransferer.start();
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		stopConection();
		comunicatorListener.setConectionStatus(false);
	}
}
