package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class Client extends ClientComunicator {

	public Client(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		dataTransferer.start();
	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage(message);
		closeConector();
		comunicatorListener.conectionStatusChange(false);
	}

}
