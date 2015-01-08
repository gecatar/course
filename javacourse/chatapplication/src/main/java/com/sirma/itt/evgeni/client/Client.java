package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

/**
 * Manage sending and receiving messages between Client and Server.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Client implements Comunicator {

	private final ComunicatorListener comunicatorListener;
	private Conector conector;
	private DataTransferator transferator;
	private String name;

	public Client(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	/**
	 * Start connection.
	 */
	@Override
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this, ip, port);
			conector.start();
		}
	}

	/**
	 * Stop connection.
	 */
	@Override
	public void stopConection() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
		closeUserSession(transferator);
	}

	/**
	 * Save DataTranferathor and start communication between Client and Server.
	 */
	@Override
	public void addUserSession(DataTransferator transferator) {
		addDataTransferator(transferator);
		transferator.start();
		comunicatorListener.setConectionStatus("Conected...");
		sendUserData();
	}

	/**
	 * Stop and delete DataTransferator.
	 */
	@Override
	public void closeUserSession(DataTransferator transferator) {
		removeDataTransferator(transferator);
		conector = null;
	}

	/**
	 * Send message to server.
	 */
	@Override
	public void sendMesage(String receiver, String text) {
		transferator.sendData(new Mesage(this.name, receiver, text));
	}

	/**
	 * Set DataTransferator.
	 */
	public void addDataTransferator(DataTransferator transferator) {
		this.transferator = transferator;
	}

	/**
	 * wefwefwe messages.
	 */
	@Override
	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.INVALID_USER_NAME) {
			comunicatorListener.setConectionStatus("Invalid User Name...");
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			comunicatorListener.showMesage(mesage.sender, mesage.text);
		}

		if (mesage.commandID == MesageCommand.USER_CONECTED) {
			comunicatorListener.addUser(mesage.sender);
		}
		if (mesage.commandID == MesageCommand.USER_DISCONECTED) {
			comunicatorListener.removeUser(mesage.sender);
		}
	}

	/**
	 * Close connector and resources that are used.
	 */
	@Override
	public void closeConectorSession() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
		comunicatorListener.setConectionStatus("Error when Conecting...");
	}

	/**
	 * Send user details to server.
	 */
	private void sendUserData() {
		transferator.sendData(new Mesage(name, MesageCommand.USER_LOG_IN));
	}

	/**
	 * Delete DataTransferator.
	 */
	private synchronized void removeDataTransferator(
			DataTransferator dataTransferator) {
		if (dataTransferator != null) {
			comunicatorListener.setConectionStatus("Disconected...");
			dataTransferator.closeSocket();
		}
		transferator = null;
	}

	/**
	 * Set nickname.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
}