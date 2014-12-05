package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.UILIstener;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientApp implements UILIstener, ComunicatorListener {

	Comunicator comunicator;
	ViewPanell viewPanell;

	public ClientApp() {
		comunicator = new Client(this);
		viewPanell = new ViewPanell(this);
		new Window(viewPanell);
	}

	public void setConectionStatus(boolean conected) {
		// TODO Auto-generated method stub client

	}

	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub client
		viewPanell.displayMessage(name, text);
	}

	public void addUser(String name) {
		// TODO Auto-generated method stub client
		viewPanell.addUser(name);
	}

	public void removeUser(String name) {
		// TODO Auto-generated method stub client
		viewPanell.removeUser(name);
	}

	public void startConection(String nickname, String ip, String port) {
		// TODO Auto-generated method stub interface
		comunicator.setName(nickname);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	public void stopConection() {
		// TODO Auto-generated method stub interface
		comunicator.stopConection();
	}

	public void sendMessage(String name, String message) {
		// TODO Auto-generated method stub interface

	}
}
