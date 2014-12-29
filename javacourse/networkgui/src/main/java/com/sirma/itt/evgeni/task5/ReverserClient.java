package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;

public class ReverserClient extends ClientComunicator {

	public ReverserClient(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		comunicatorListener.conectionStatusChange(true);
		dataTransferer.start();
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		comunicatorListener.conectionStatusChange(false);
		closeConector();
	}

}
