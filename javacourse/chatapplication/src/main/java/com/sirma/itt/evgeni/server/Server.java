package com.sirma.itt.evgeni.server;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;

public class Server implements Comunicator {

	Controler controler;
	Conector conector;

	Map<String, DataTransferator> users = new ConcurrentHashMap<String, DataTransferator>();

	public Server(Controler controler) {
		this.controler = controler;
		controler.setComunicator(this);
	}

	public void startConection(Conector conector) {
		if (conector == null) {
			this.conector = conector;
			// receiver.start();
		}
	}

	public void stopConection() {
		if (conector != null) {
			conector.closeSocket();
		}
		conector = null;
		// ----------------------------
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().closeSocket();
		}
		// ----------------------------
	}

	public void setConection(DataTransferator transferator) {
		controler.setConectionStatus(true);
		transferator.start();
	}

	public void notifyUsers(String name) {
		Mesage msg = new Mesage(name);
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().sendData(msg);
		}
	}

	public void notifyUsersLeaving(String name) {
		Set<String> keys = users.keySet();
		Mesage msg = new Mesage(3, name);
		for (String key : keys) {
			users.get(key).sendData(msg);
		}
	}

	private void sendUsersList(DataTransferator transferator) {
		Set<String> keys = users.keySet();
		for (String key : keys) {
			transferator.sendData(new Mesage(key));
		}
	}

	private void addUser(String name, DataTransferator transferator) {
		if (!users.containsKey(name)) {
			users.put(name, transferator);
			sendUsersList(transferator);
			notifyUsers(name);
		} else {
			transferator.closeSocket();
		}
	}

	public void sendMesage(String sender, String receiver, String text) {
		if (users.containsKey(receiver)) {
			users.get(receiver).sendData(new Mesage(sender, receiver, text));
		}
	}


	public void startConection(String ipAdress, int port, String nickname) {
		// TODO Auto-generated method stub

	}

	public void sendMesage(Mesage mesage) {
		// TODO Auto-generated method stub

	}

	public void removeConector() {
		// TODO Auto-generated method stub

	}

	public void addDataTransferator(DataTransferator transferator) {
		// TODO Auto-generated method stub

	}

	public boolean removeDataTransferator(DataTransferator transferator) {
		// TODO Auto-generated method stub
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			if (user.getValue() == transferator) {
				users.remove(user.getKey());
				notifyUsersLeaving(user.getKey());
				return true;
			}
		}
		return false;

	}

	public void processMesage(Mesage mesage, DataTransferator transferator) {
		// TODO Auto-generated method stub
		if (mesage.commandID == 0) {
			addUser(mesage.sender, transferator);
		}
		if (mesage.commandID == 1) {
			sendMesage(mesage.sender, mesage.receiver, mesage.text);
		}

	}
}