package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;

public class ServerComunicator extends Comunicator {

	@Override
	public void openSession(DataTransferer dataTransferer) {
		this.openSession(dataTransferer);
	}

	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {

	}

	@Override
	public void closeSession(DataTransferer dataTransferer) {
		this.closeSession(dataTransferer);
	}
}
