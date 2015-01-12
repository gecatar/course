package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class ClientComunicator extends Comunicator {

	public ClientComunicator() {
		conector = new ClientConector(this);
	}

	@Override
	public void openSession(DataTransferer dataTransferer) {
		super.openSession(dataTransferer);
		listener.setConectionStatus(MesageCommand.USER_CONECTED);
	}

	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {

	}

	@Override
	public void closeSession(DataTransferer dataTransferer) {
		super.closeSession(dataTransferer);
	}
}
