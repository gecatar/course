package com.sirma.itt.evgeni.tas3.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;

public class Client implements Comunicator {

	ComunicatorListener comunicatorListener;

	public Client(ComunicatorListener comunicatorListener) {
		this.comunicatorListener = comunicatorListener;
	}

	@Override
	public void startConection(String ip, int port) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopConection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUserSession(DataTransferator transferator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeUserSession(DataTransferator transferator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConectorSession() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMesage(Mesage mesage, DataTransferator transferator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMesage(String name, String text) {
		// TODO Auto-generated method stub

	}

}
