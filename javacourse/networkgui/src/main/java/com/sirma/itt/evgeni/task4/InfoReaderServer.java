package com.sirma.itt.evgeni.task4;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

/**
 * Send information about clients.
 * 
 * @author GecaTM
 *
 */
public class InfoReaderServer extends ServerComunicator {

	private ArrayList<DataTransferer> users = new ArrayList<DataTransferer>();

	public InfoReaderServer(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	/**
	 * Add user session.
	 */
	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		notifyUserLogIn();
		users.add(dataTransferer);
		dataTransferer.start();
		sendInfoToUser(dataTransferer);
		comunicatorListener.displayMessage("New user conected to server.");
	}

	/**
	 * Send information to user.
	 */
	private void sendInfoToUser(DataTransferer dataTransferer) {
		dataTransferer.sendData("You are user number:" + users.size());
	}

	/**
	 * Notify users when client leave.
	 */
	private void notifyForUserLeaving() {
		sendMessageToAll("User leave. New count:" + users.size());
	}

	/**
	 * Notify users when user log in/
	 */
	private void notifyUserLogIn() {
		sendMessageToAll("User conected. New count:" + users.size());
	}

	/**
	 * Send message to all.
	 */
	private void sendMessageToAll(String message) {
		for (DataTransferer temp : users) {
			temp.sendData(message);
		}
	}

	/**
	 * Close user session.
	 */
	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		if (users.contains(dataTransferer)) {
			users.remove(dataTransferer);
			dataTransferer.closeSocket();
			comunicatorListener.displayMessage("User disconected from server.");
			notifyForUserLeaving();
		}
	}

	/**
	 * Stop connection.
	 */
	@Override
	public void stopConection() {
		super.stopConection();
		for (DataTransferer transferer : users) {
			transferer.closeSocket();
		}
		users.clear();
	}

}
