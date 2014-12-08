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
	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this, ip, port);
			conector.start();
		}
	}

	/**
	 * Send message to server.
	 */
	public void sendMesage(String receiver, String text) {
		transferator.sendData(new Mesage(this.name, receiver, text));
	}

	/**
	 * Stop connection.
	 */
	public void stopConection() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
		closeUserSession(transferator);
	}

	/**
	 * Send user details to server.
	 */
	public void sendUserData() {
		transferator.sendData(new Mesage(name, MesageCommand.USER_LOG_IN));
	}

	/**
	 * Save DataTranferathor and start communication between Client and Server.
	 */
	public void addUserSession(DataTransferator transferator) {
		addDataTransferator(transferator);
		transferator.start();
		comunicatorListener.setConectionStatus("Conected...");
		sendUserData();
	}

	/**
	 * Stop and delete DataTransferator.
	 */
	public void closeUserSession(DataTransferator transferator) {
		comunicatorListener.setConectionStatus("Disconected...");
		removeDataTransferator(transferator);
		conector = null;
	}

	/**
	 * Set DataTransferator.
	 * 
	 * @param transferator
	 */
	public void addDataTransferator(DataTransferator transferator) {
		this.transferator = transferator;
	}

	/**
	 * Delete DataTransferator.
	 * 
	 * @param dataTransferator
	 */
	public synchronized void removeDataTransferator(
			DataTransferator dataTransferator) {
		if (dataTransferator != null) {
			dataTransferator.closeSocket();
		}
		transferator = null;
	}

	/**
	 * wefwefwe messages.
	 */
	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.INVALID_USER_NAME) {
			closeUserSession(transferator);
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
	public void closeConectorSession() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
	}

	/**
	 * Set nickname.
	 */
	public void setName(String name) {
		this.name = name;
	}
}