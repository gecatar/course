package com.sirma.itt.evgeni.client.view;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

public class TestComunicator implements Comunicator {

	ComunicatorListener comunicatorListener;
	String name;

	public TestComunicator(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	public void startConection(String ip, int port) {
		// TODO Auto-generated method stub
		System.out.println("Starting conection @" + ip + ":" + port);
		comunicatorListener.setConectionStatus(true);
	}

	public void stopConection() {
		// TODO Auto-generated method stub
		System.out.println("Stoping conection:");
		comunicatorListener.setConectionStatus(false);
	}

	public void addUserSession(DataTransferator transferator) {
		// TODO Auto-generated method stub
		comunicatorListener.setConectionStatus(true);
	}

	public void closeUserSession(DataTransferator transferator) {
		// TODO Auto-generated method stub

	}

	public void closeConectorSession() {
		// TODO Auto-generated method stub

	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		System.out.println("Name is set to:" + name);
	}

	public void processMesage(Mesage mesage, DataTransferator transferator) {
		// TODO Auto-generated method stub
		if (mesage.commandID == MesageCommand.TEXT_MESAGE) {
			comunicatorListener.showMesage(mesage.sender, mesage.text);
		}

		if (mesage.commandID == MesageCommand.USER_CONECTED) {
			comunicatorListener.addUser(mesage.sender);
		}
		if (mesage.commandID == MesageCommand.USER_DISCONECTED) {
			comunicatorListener.removeUser(mesage.sender);
		}

	}

	public void sendMesage(Mesage mesage) {
		// TODO Auto-generated method stub

	}

}
