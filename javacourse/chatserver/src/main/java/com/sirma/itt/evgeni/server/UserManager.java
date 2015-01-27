package com.sirma.itt.evgeni.server;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class UserManager {

	private final Map<String, DataTransferer> users = new ConcurrentHashMap<String, DataTransferer>();

	/**
	 * Save user in list of registered users.
	 */
	public void registerUser(String name, DataTransferer transferator) {
		if (!users.containsKey(name)) {
			addUserInMap(name, transferator);
			sendUsersList(transferator);
			notifyForNewUser(name);
		} else {
			notifyForBadName(transferator);
			transferator.closeSocket();
		}
	}

	/**
	 * Remove user from map. Close connection and notify other users.
	 */
	public void removeUser(DataTransferer transferator) {
		if (isUserInMap(transferator)) {
			String name = getUserName(transferator);
			users.remove(name);
			transferator.closeSocket();
			notifyForUserLeaving(name);
		}
	}

	/**
	 * Send message to specified user.
	 */
	public void sendMesageToUser(String sender, String receiver, String text) {
		if (users.containsKey(receiver)) {
			users.get(receiver).sendData(new Mesage(sender, receiver, text));
		}
	}

	/**
	 * Close all user sessions.
	 */
	public void removeUsersSessions() {
		for (Entry<String, DataTransferer> user : users.entrySet()) {
			user.getValue().closeSocket();
		}
		users.clear();
	}

	/**
	 * Return name of user.
	 */
	public String getUserName(DataTransferer transferator) {
		for (Entry<String, DataTransferer> user : users.entrySet()) {
			if (user.getValue() == transferator) {
				return user.getKey();
			}
		}
		return "";
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
	 * Send all registered users at moment of registering on user.
	 */
	private void sendUsersList(DataTransferer transferator) {
		Set<String> keys = users.keySet();
		for (String key : keys) {
			transferator.sendData(new Mesage(key, MesageCommand.USER_CONECTED));
		}
	}

	/**
	 * Check is user in conversation list.
	 */
	private boolean isUserInMap(DataTransferer transferator) {
		return (users.containsValue(transferator));
	}

	/**
	 * Add user to list whit registered users.
	 */
	private void addUserInMap(String name, DataTransferer transferator) {
		if (!users.containsKey(name)) {
			users.put(name, transferator);
		}
	}

	/**
	 * Notify user for invalid user name.
	 */
	private void notifyForBadName(DataTransferer transferator) {
		transferator.sendData(new Mesage(MesageCommand.INVALID_USER_NAME));
	}

	/**
	 * Send message to all users.
	 */
	private void sendMessageToAll(Mesage message) {
		for (Entry<String, DataTransferer> user : users.entrySet()) {
			user.getValue().sendData(message);
		}
	}

	/**
	 * Print all user registered on server.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Users:").append("\n");
		for (String key : users.keySet()) {
			stringBuilder.append(key).append("\n");
		}
		return stringBuilder.toString().trim();
	}
}
