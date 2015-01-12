package com.sirma.itt.evgeni.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class ServerComunicator extends Comunicator {

	private static final Logger LOGGER = Logger
			.getLogger(ServerComunicator.class.getName());
	private UserManager userManager = new UserManager();

	public ServerComunicator(ComunicatorListener listener) {
		super(listener);
		conector = new ServerConector(this);
	}

	@Override
	public void openSession(DataTransferer dataTransferer) {
		super.openSession(dataTransferer);
		LOGGER.log(Level.INFO, "New session opened.");
	}

	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			userManager.registerUser(mesage.sender, dataTransferer);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			userManager.sendMesageToUser(mesage.sender, mesage.receiver,
					mesage.text);
		}
	}

	@Override
	public void closeSession(DataTransferer dataTransferer) {
		super.closeSession(dataTransferer);
		LOGGER.log(Level.INFO, "Session closed.");
	}
}
