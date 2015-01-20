package com.sirma.itt.evgeni.server;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

/**
 * Create connection whit clients and redirect messages.
 * 
 * @author GecaTM
 *
 */
public class ServerComunicator extends Comunicator {

	private static final Logger LOGGER = Logger
			.getLogger(ServerComunicator.class.getName());
	private UserManager userManager = new UserManager();

	public ServerComunicator(ComunicatorListener listener) {
		super(listener);
		conector = new ServerConector(this);
	}

	/**
	 * Open new user session.
	 */
	@Override
	public void openSession(DataTransferer dataTransferer) {
		super.openSession(dataTransferer);
		LOGGER.log(Level.INFO, "New session opened.");
	}

	/**
	 * Process message.
	 */
	@Override
	public void processMesage(Mesage mesage, DataTransferer dataTransferer) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			userManager.registerUser(mesage.sender, dataTransferer);
			listener.addUser(mesage.sender);
			LOGGER.log(Level.INFO, mesage.sender + " - enter");
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			userManager.sendMesageToUser(mesage.sender, mesage.receiver,
					mesage.text);
		}
	}

	/**
	 * Close user session.
	 */
	@Override
	public void closeSession(DataTransferer dataTransferer) {
		super.closeSession(dataTransferer);
		userManager.removeUser(dataTransferer);
		listener.removeUser(userManager.getUserName(dataTransferer));
		LOGGER.log(Level.INFO, "Session closed.");
	}

	@Override
	public void close() {
		userManager.removeUsersSessions();
	}

	/**
	 * Send message.
	 */
	@Override
	public void sendMessage(String name, String text) {

	}
}
