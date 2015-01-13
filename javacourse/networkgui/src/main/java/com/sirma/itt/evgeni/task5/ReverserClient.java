package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class ReverserClient extends ClientComunicator {

	private DataTransferer dataTransferer;

	public ReverserClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(true);
		this.dataTransferer = dataTransferer;
		dataTransferer.start();
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		comunicatorListener.setConectionStatus(false);
		closeConector();
	}

	@Override
	public void receiveMessage(String message, DataTransferer transferer) {
		comunicatorListener.displayMessage("Reversed message:" + message);
	}

	@Override
	public void sendMessage(String message) {
		if (dataTransferer != null) {
			dataTransferer.sendData(message);
		}
	}

}
