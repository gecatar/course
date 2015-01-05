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

/**
 * Send and receive messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Server implements Comunicator {

	private final ComunicatorListener comunicatorListener;
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
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().closeSocket();
		}
		users.clear();
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
		transferator.closeSocket();
		if (isUserInMap(transferator)) {
			String name = getUserName(transferator);
			removeUserFromMap(name);
			notifyForUserLeaving(name);
			comunicatorListener.removeUser(name);
		}
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
	 * Send message to specified user.
	 */
	private boolean sendMesageToUser(String sender, String receiver, String text) {
		if (users.containsKey(receiver)) {
			users.get(receiver).sendData(new Mesage(sender, receiver, text));
			return true;
		}
		return false;
	}

	/**
	 * Remove user from users list.
	 */
	private boolean removeUserFromMap(String name) {
		if (users.containsKey(name)) {
			users.remove(name);
			return true;
		}
		return false;
	}

	/**
	 * Add user to list whit registered users.
	 */
	private boolean addUserInMap(String name, DataTransferator transferator) {
		if (!users.containsKey(name)) {
			users.put(name, transferator);
			comunicatorListener.addUser(name);
			return true;
		}
		return false;
	}

	/**
	 * Notify registered users for new users registered.
	 */
	private void notifyForNewUser(String name) {
		Mesage message = new Mesage(name, MesageCommand.USER_CONECTED);
		sendMessageToAll(message);
	}

	/**
	 * Notify registered users for leaving users.
	 */
	private void notifyForUserLeaving(String name) {
		Mesage message = new Mesage(name, MesageCommand.USER_DISCONECTED);
		sendMessageToAll(message);
	}

	/**
	 * Send message to all users.
	 */
	private void sendMessageToAll(Mesage message) {
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().sendData(message);
		}
	}

	/**
	 * Send all registered users at moment of registering on user.
	 */
	private void sendUsersList(DataTransferator transferator) {
		Set<String> keys = users.keySet();
		for (String key : keys) {
			transferator.sendData(new Mesage(key, MesageCommand.USER_CONECTED));
		}
	}

	/**
	 * Save user in list of registered users.
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
	 */
	private void notifyForBadName(DataTransferator transferator) {
		transferator.sendData(new Mesage(MesageCommand.INVALID_USER_NAME));
	}

	/**
	 * Return name of user.
	 */
	private String getUserName(DataTransferator transferator) {
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			if (user.getValue() == transferator) {
				return user.getKey();
			}
		}
		return "";
	}

	/**
	 * Check is user in conversation list.
	 */
	private boolean isUserInMap(DataTransferator transferator) {
		if (users.containsValue(transferator)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Redirect message.
	 */
	@Override
	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			registerUser(mesage.sender, transferator);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			sendMesageToUser(mesage.sender, mesage.receiver, mesage.text);
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