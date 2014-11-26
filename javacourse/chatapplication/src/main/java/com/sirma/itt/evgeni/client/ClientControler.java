package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;
import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientControler implements Controler {

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

	public void stopConection() {
		comunicator.stopConection();
	}

	public void setConectionStatus(boolean conected) {
		window.setConectionStatus(conected);
	}

	public void showMesage(String sender, String text) {
		window.showMesage(sender, text);

	}

	public void sendMesage(String sender, String receiver, String text) {
		comunicator.sendMesage(new Mesage(sender, receiver, text));
	}

	public void addUser(String name) {
		window.addUser(name);
	}

	public void removeUser(String name) {
		window.removeUser(name);
	}
}