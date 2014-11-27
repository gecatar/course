package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class Client implements Comunicator {

	private Controler controler;
	private Conector conector;
	private DataTransferator transferator;
	private String name;

	public Client(Controler controler) {
		this.controler = controler;
		controler.setComunicator(this);
	}

	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this, ip, port);
			conector.start();
		}
	}

	public void stopConection() {
		if (conector != null) {
			conector.stopConector();
			conector = null;
		}
		closeUserSession(transferator);
	}

	public void sendUserData() {
		sendMesage(new Mesage(name, MesageCommand.USER_LOG_IN));
	}

	public void addUserSession(DataTransferator transferator) {
		addDataTransferator(transferator);
		controler.setConectionStatus(true);
		sendUserData();
	}

	public void closeUserSession(DataTransferator transferator) {
		controler.setConectionStatus(false);
		removeDataTransferator(transferator);
	}

	public void addDataTransferator(DataTransferator transferator) {
		this.transferator = transferator;
	}

	public void removeDataTransferator(DataTransferator dataTransferator) {
		transferator = null;
	}

	public void processMesage(Mesage mesage, DataTransferator transferator) {
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			controler.showMesage(mesage.sender, mesage.text);
		}

		if (mesage.commandID == MesageCommand.USER_CONECTED) {
			controler.addUser(mesage.sender);
		}
		if (mesage.commandID == MesageCommand.USER_DISCONECTED) {
			controler.removeUser(mesage.sender);
		}
	}

	public void sendMesage(Mesage mesage) {
		transferator.sendData(mesage);
	}

	public void closeConectorSession() {
		// TODO Auto-generated method stub

	}

	public void setName(String name) {
		this.name = name;
	}
}