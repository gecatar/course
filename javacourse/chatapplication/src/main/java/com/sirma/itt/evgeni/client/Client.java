package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;

public class Client implements Comunicator{

	private Controler controler;
	private Conector conector;
	private DataTransferator transferator;
	private String nickname;

	public Client(Controler controler) {
		this.controler = controler;
		controler.setComunicator(this);
	}
	
	public void startConection(Conector conector) {
		if (conector == null) {
			this.conector = conector;
		//	conector.start();
		}
	}

	public void stopConection() {
		if (conector != null) {
			conector.closeSocket();
			conector = null;
		}
	}

	public void removeConector() {
		conector = null;
	}
	

	public void processMesage(Mesage mesage, DataTransferator transferator) {
		controler.proccesMesage(mesage);
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
		this.transferator.sendData(new Mesage(0, nickname));
		controler.setConectionStatus(true);
		
	}

	public boolean removeDataTransferator(DataTransferator dataTransferator) {
		transferator = null;
		stopConection();
		controler.setConectionStatus(false);
		return true;
	}

}