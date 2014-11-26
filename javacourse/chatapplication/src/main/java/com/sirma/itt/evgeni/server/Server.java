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
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class Server implements Comunicator {

	Controler controler;
	Conector conector;

	Map<String, DataTransferator> users = new ConcurrentHashMap<String, DataTransferator>();

	public Server(Controler controler) {
		this.controler = controler;
		controler.setComunicator(this);
	}
	
	public void startConection(String ipAdress, int port) {
		// TODO Auto-generated method stub

	}

	public void stopConection() {
		if (conector != null) {
		//	conector.closeSocket();
		}
		conector = null;
		// ----------------------------
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().closeSocket();
		}
		// ----------------------------
	}
	
	public void addDataTransferator(DataTransferator transferator) {
		transferator.start();
	}
	
	public void sendMesage(String sender, String receiver, String text) {
		if (users.containsKey(receiver)) {
			users.get(receiver).sendData(new Mesage(sender, receiver, text));
		}
	}

	public void removeConector() {
		// TODO Auto-generated method stub

	}

	public boolean removeDataTransferator(DataTransferator transferator) {
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			if (user.getValue() == transferator) {
				users.remove(user.getKey());
				notifyUsersLeaving(user.getKey());
				return true;
			}
		}
		return false;

	}



	public void notifyUsers(String name) {
		Mesage mesage = new Mesage(name, MesageCommand.USER_CONECTED);
		for (Entry<String, DataTransferator> user : users.entrySet()) {
			user.getValue().sendData(mesage);
		}
	}

	public void notifyUsersLeaving(String name) {
		Set<String> keys = users.keySet();
		Mesage mesage = new Mesage(name, MesageCommand.USER_DISCONECTED);
		for (String key : keys) {
			users.get(key).sendData(mesage);
		}
	}

	private void sendUsersList(DataTransferator transferator) {
		Set<String> keys = users.keySet();
		for (String key : keys) {
			transferator.sendData(new Mesage(key, MesageCommand.USER_CONECTED));
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


	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.USER_LOG_IN) {
			addUser(mesage.sender, transferator);
		}
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			sendMesage(mesage.sender, mesage.receiver, mesage.text);
		}

	}

	public void sendMesage(Mesage mesage) {
		// TODO Auto-generated method stub
		
	}
}