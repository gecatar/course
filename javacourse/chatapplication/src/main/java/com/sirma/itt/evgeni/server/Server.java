package com.sirma.itt.evgeni.server;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class Server implements Comunicator {

	ComunicatorListener comunicatorListener;
	Conector conector;
	String name;

	Map<String, DataTransferator> users = new ConcurrentHashMap<String, DataTransferator>();

	public Server(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	/**
	 * Create new thread Conector and wait for incoming connection.
	 */
	public void startConection(String ipAdress, int port) {
		if (conector == null) {
			conector = new ServerConector(this, ipAdress, port);
			conector.start();
		}
	}

	/**
	 * Stop execution on Conector and close all DataTransferators.
	 */
	public void stopConection() {
		if (conector != null) {
			conector.stopConector();
		}
		conector = null;
		// ----------------------------
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().closeSocket();
		}
		users.clear();
		// ----------------------------
	}

	/**
	 * Start DataTransferator. Add user to unregistered user list.
	 */
	public void addUserSession(DataTransferator transferator) {
		transferator.start();
		comunicatorListener.setConectionStatus("");

	}

	/**
	 * Close User DataTransferator, remove user from list and notify all users.
	 */
	public void closeUserSession(DataTransferator transferator) {
		transferator.closeSocket();
		if (isUserInMap(transferator)) {
			String name = getUserName(transferator);
			removeUserFromMap(name);
			notifyForUserLeaving(name);
		}
	}

	/**
	 * Check is user in conversation list.
	 * 
	 * @param transferator
	 * @return
	 */
	public boolean isUserInMap(DataTransferator transferator) {
		if (users.containsValue(transferator)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Close Conector. That mean that no more incoming connection are available.
	 */
	public void closeConectorSession() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
	}

	public void addDataTransferator(DataTransferator transferator) {
		transferator.start();
	}

	public void sendMesageToUser(String sender, String receiver, String text) {
		if (users.containsKey(receiver)) {
			users.get(receiver).sendData(new Mesage(sender, receiver, text));
		}
	}

	/**
	 * Remove user from users list.
	 * 
	 * @param name
	 *            the name of user that will be removed.
	 * @return true if operation is successful.
	 */
	public boolean removeUserFromMap(String name) {
		if (users.containsKey(name)) {
			users.remove(name);
			return true;
		}
		return false;
	}

	/**
	 * Add user to list whit registered users.
	 * 
	 * @param name
	 * @param transferator
	 * @return
	 */
	public boolean addUserInMap(String name, DataTransferator transferator) {
		if (!users.containsKey(name)) {
			users.put(name, transferator);
			return true;
		}
		return false;
	}

	/**
	 * Notify registered users for new users registered.
	 * 
	 * @param name
	 */
	public void notifyForNewUser(String name) {
		Mesage mesage = new Mesage(name, MesageCommand.USER_CONECTED);
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().sendData(mesage);
		}
	}

	/**
	 * Notify registered users for leaving users.
	 * 
	 * @param name
	 */
	public void notifyForUserLeaving(String name) {
		Set<String> keys = users.keySet();
		Mesage mesage = new Mesage(name, MesageCommand.USER_DISCONECTED);
		for (String key : keys) {
			users.get(key).sendData(mesage);
		}
	}

	/**
	 * Send all registered users at moment of registering on user.
	 * 
	 * @param transferator
	 */
	private void sendUsersList(DataTransferator transferator) {
		Set<String> keys = users.keySet();
		for (String key : keys) {
			transferator.sendData(new Mesage(key, MesageCommand.USER_CONECTED));
		}
	}

	/**
	 * Save user in list of registered users.
	 * 
	 * @param name
	 *            the name of user that will be added.
	 * @param transferator
	 */
	private void registerUser(String name, DataTransferator transferator) {
		if (addUserInMap(name, transferator)) {
			sendUsersList(transferator);
			notifyForNewUser(name);
		} else {
			notifyForBadName(transferator);
			transferator.closeSocket();
		}
	}

	/**
	 * Notify user for invalid user name.
	 * 
	 * @param transferator
	 */
	public void notifyForBadName(DataTransferator transferator) {
		transferator.sendData(new Mesage(MesageCommand.INVALID_USER_NAME));
	}

	/**
	 * Return name of user.
	 * 
	 * @param transferator
	 * @return return empty string if user is not registered.
	 */
	public String getUserName(DataTransferator transferator) {
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			if (user.getValue() == transferator) {
				return user.getKey();
			}
		}
		return "";
	}

	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			registerUser(mesage.sender, transferator);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			sendMesageToUser(mesage.sender, mesage.receiver, mesage.text);
		}

	}

	public void sendMesage(String receiver, String text) {
		// TODO Auto-generated method stub

	}

	public void setName(String name) {
		this.name = name;
	}

}