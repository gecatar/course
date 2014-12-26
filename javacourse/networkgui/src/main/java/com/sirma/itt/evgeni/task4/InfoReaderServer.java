package com.sirma.itt.evgeni.task4;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.ServerComunicator;

public class InfoReaderServer extends ServerComunicator {

	private ArrayList<DataTransferer> users = new ArrayList<DataTransferer>();

	public InfoReaderServer(ComunicatorListener comunicatorListener) {
		super(comunicatorListener);
	}

	@Override
	public void addUserSession(DataTransferer dataTransferer) {
		notifyUserLogIn();
		users.add(dataTransferer);
		dataTransferer.start();
		sendInfoToUser(dataTransferer);
		comunicatorListener.displayMessage("New user conected to server.");
	}

	private void sendInfoToUser(DataTransferer dataTransferer) {
		dataTransferer.sendData("You are user number:" + users.size());
	}

	private void notifyForUserLeaving() {
		sendMessageToAll("User leave. New count:" + users.size());
	}

	private void notifyUserLogIn() {
		sendMessageToAll("User conected. New count:" + users.size());
	}

	private void sendMessageToAll(String message) {
		for (DataTransferer temp : users) {
			temp.sendData(message);
		}
	}

	@Override
	public void closeUsersession(DataTransferer dataTransferer) {
		if (users.contains(dataTransferer)) {
			users.remove(dataTransferer);
			dataTransferer.closeSocket();
			comunicatorListener.displayMessage("User disconected from server.");
			notifyForUserLeaving();
		}
	}

	@Override
	public void stopConection() {
		super.stopConection();
		for (DataTransferer transferer : users) {
			transferer.closeSocket();
		}
		users.clear();
	}

}
