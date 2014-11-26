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
	private String nickname;

	public Client(Controler controler) {
		this.controler = controler;
		controler.setComunicator(this);
	}

	public void startConection(String ip, int port) {
		if (conector == null) {
			conector = new ClientConector(this,ip,port);
			conector.start();
		}
	}

	public void stopConection() {
		if (conector != null) {
			// conector.closeSocket();
			conector = null;
		}
	}

	public void removeConector() {
		conector = null;
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

	public void removeConection() {
		transferator = null;
		stopConection();
		controler.setConectionStatus(false);
	}

	public void sendMesage(Mesage mesage) {
		if (mesage.sender.length() > 0) {
			transferator.sendData(mesage);
		}

	}

	public void addDataTransferator(DataTransferator transferator) {
		this.transferator = transferator;
		this.transferator.start();
		this.transferator.sendData(new Mesage(nickname,
				MesageCommand.USER_LOG_IN));
		controler.setConectionStatus(true);
	}

	public boolean removeDataTransferator(DataTransferator dataTransferator) {
		transferator = null;
		stopConection();
		controler.setConectionStatus(false);
		return true;
	}

}