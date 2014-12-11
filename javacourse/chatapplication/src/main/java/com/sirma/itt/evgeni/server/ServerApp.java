package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ConectorShutdownHook;
import com.sirma.itt.evgeni.comunication.UILIstener;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Create connection whit users, send and receive messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
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

	/**
	 * Start connection.
	 */
	@Override
	public void startConection(String name, String ip, String port) {
		comunicator.setName(name);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	/**
	 * Stop connection.
	 */
	@Override
	public void stopConection() {
		// TODO Auto-generated method stub interface
		comunicator.stopConection();

	}

	@Override
	public void setConectionStatus(String conectionCondition) {
		// TODO Auto-generated method stub server

	}

	@Override
	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub server

	}

	@Override
	public void addUser(String name) {
		// TODO Auto-generated method stub server

	}

	@Override
	public void removeUser(String name) {
		// TODO Auto-generated method stub server

	}

	@Override
	public void sendMessage(String receiver, String text) {
		// TODO Auto-generated method stub interface

	}

	/**
	 * Start application.
	 * 
	 * @param args
	 */
	// Runner------------------------------
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerApp();
	}
	// -------------------------------------
}
