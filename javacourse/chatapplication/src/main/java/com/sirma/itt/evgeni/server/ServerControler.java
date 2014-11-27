package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.Window;

public class ServerControler implements Controler {
	
	Comunicator comunicator;
	Window window;

	public void setComunicator(Comunicator comunicator) {
		this.comunicator = comunicator;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public void startConection(String ip, String port) {
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	public void setConectionStatus(boolean conected) {
		// TODO Auto-generated method stub

	}

	public void stopConection() {
		// TODO Auto-generated method stub

	}

	public void addUser(String name) {
		// TODO Auto-generated method stub

	}

	public void removeUser(String name) {
		// TODO Auto-generated method stub

	}

	public void sendMesage(String sender, String receiver, String text) {
		// TODO Auto-generated method stub

	}

	public void showMesage(String sender, String text) {
		// TODO Auto-generated method stub

	}

	public void setName(String name) {
		comunicator.setName(name);
		
	}

}
