package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class ClientComunicator extends Comunicator {

	public ClientComunicator(ComunicatorListener listener) {
		super(listener);
		conector = new ClientConector(this);
	}

	@Override
	public void openSession(DataTransferer dataTransferer) {
		super.openSession(dataTransferer);
		listener.setConectionStatus(MesageCommand.USER_CONECTED);
	}

	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {
		if (mesage.commandID == MesageCommand.INVALID_USER_NAME) {
			listener.setConectionStatus(mesage.commandID);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			listener.showMesage(mesage.sender, mesage.text);
		}

		if (mesage.commandID == MesageCommand.USER_CONECTED) {
			listener.addUser(mesage.sender);
		}
		if (mesage.commandID == MesageCommand.USER_DISCONECTED) {
			listener.removeUser(mesage.sender);
		}
	}

	@Override
	public void closeSession(DataTransferer dataTransferer) {
		super.closeSession(dataTransferer);
		listener.setConectionStatus(MesageCommand.USER_DISCONECTED);
	}

}
