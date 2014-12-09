package com.sirma.itt.evgeni.tas3.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;

public class ServerApp implements ComunicatorListener, ActionListener {

	Comunicator comunicator = new Server();

	public ServerApp() {
	}

	@Override
	public void setConectionStatus(String conectionCondition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String name) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
