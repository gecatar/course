package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientControler implements Controler{

	Client client;
	Window window;

	public void setComunicator(Client client) {
		this.client = client;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public void startConection(String ipAdress, int port, String nickname) {
	//	client.startConection(ipAdress, port, nickname);
	}

	public void proccesMesage(Mesage mesage) {
		if (mesage.commandID == 1) {
			window.displayMesage(mesage.sender, mesage.text);
		}
		if (mesage.commandID == 2) {
			window.addUser(mesage.sender);
		}
		if (mesage.commandID == 3) {
			window.removeUser(mesage.sender);
		}
	}

	public void sendMesage(Mesage mesage) {
		client.sendMesage(mesage);
	}

	public void stopConection() {
		client.stopConection();
	}

	public void setConectionStatus(boolean conected) {
		window.setConectionStatus(conected);
	}

	public void setComunicator(Comunicator comunicator) {
		// TODO Auto-generated method stub
		
	}

}