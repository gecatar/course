package com.sirma.itt.evgeni.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;

public class ServerComunicator extends Comunicator {

	private static final Logger LOGGER = Logger
			.getLogger(ServerComunicator.class.getName());

	public ServerComunicator() {
		conector = new ServerConector(this);
	}

	@Override
	public void openSession(DataTransferer dataTransferer) {
		super.openSession(dataTransferer);
		LOGGER.log(Level.INFO, "New session opened.");
	}

	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {

	}

	@Override
	public void closeSession(DataTransferer dataTransferer) {
		super.closeSession(dataTransferer);
		LOGGER.log(Level.INFO, "Session closed.");
	}
}
