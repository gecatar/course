package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ConectorShutdownHook;
import com.sirma.itt.evgeni.comunication.UILIstener;
import com.sirma.itt.evgeni.comunication.Window;

public class ServerApp implements UILIstener, ComunicatorListener {

	Comunicator comunicator;
	ConectionPanel conectionPanel;

	public ServerApp() {
		comunicator = new Server(this);
		conectionPanel = new ConectionPanel(this);
		Runtime.getRuntime().addShutdownHook(
				new ConectorShutdownHook(comunicator));
		new Window(conectionPanel);
	}

	public void setConectionStatus(String conectionCondition) {
		// TODO Auto-generated method stub server

	}

	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub server

	}

	public void addUser(String name) {
		// TODO Auto-generated method stub server

	}

	public void removeUser(String name) {
		// TODO Auto-generated method stub server

	}

	public void startConection(String name, String ip, String port) {
		// TODO Auto-generated method stub interface
		comunicator.setName(name);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	public void stopConection() {
		// TODO Auto-generated method stub interface
		comunicator.stopConection();

	}

	public void sendMessage(String receiver, String text) {
		// TODO Auto-generated method stub interface

	}

	// Runner------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerApp();
	}
	// -------------------------------------
}
