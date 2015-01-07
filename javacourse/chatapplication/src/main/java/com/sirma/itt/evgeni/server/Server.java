package com.sirma.itt.evgeni.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

/**
 * Send and receive messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Server implements Comunicator {

	private final ComunicatorListener comunicatorListener;
	private final UserManager userManager = new UserManager();
	private Conector conector;

	private final Map<String, DataTransferator> users = new ConcurrentHashMap<String, DataTransferator>();

	public Server(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	/**
	 * Create new thread Connector and wait for incoming connection.
	 */
	@Override
	public void startConection(String ipAdress, int port) {
		if (conector == null) {
			comunicatorListener.setConectionStatus("Waiting for clients!!!");
			conector = new ServerConector(this, ipAdress, port);
			conector.start();
		}
	}

	/**
	 * Stop execution on Connector and close all DataTransferators.
	 */
	@Override
	public void stopConection() {
		comunicatorListener
				.setConectionStatus("Close all incoming conection!!!");
		closeConectorSession();
		userManager.removeUsersSessions();
	}

	/**
	 * Start DataTransferator. Add user to unregistered user list.
	 */
	@Override
	public void addUserSession(DataTransferator transferator) {
		transferator.start();
	}

	/**
	 * Close User DataTransferator, remove user from list and notify all users.
	 */
	@Override
	public void closeUserSession(DataTransferator transferator) {
		userManager.removeUser(transferator);
	}

	/**
	 * Close Connector. That mean that no more incoming connection are
	 * available.
	 */
	@Override
	public void closeConectorSession() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
	}

	/**
	 * Add data transferrer.
	 */
	public void addDataTransferator(DataTransferator transferator) {
		transferator.start();
	}

	/**
	 * Redirect message.
	 */
	@Override
	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			userManager.registerUser(mesage.sender, transferator);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			userManager.sendMesageToUser(mesage.sender, mesage.receiver,
					mesage.text);
		}
	}

	/**
	 * Set communicator name.
	 */
	@Override
	public void setName(String name) {

	}

	/**
	 * Send message.
	 */
	@Override
	public void sendMesage(String receiver, String text) {

	}

}