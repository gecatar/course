package com.sirma.itt.evgeni.task4;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.sirma.itt.evgeni.comunication.ComunicatorView;

/**
 * Send information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ServerApp extends ComunicatorView {

	Server server;

	public ServerApp() {
		setTitle("Server");
	}

	/**
	 * When UI Button is pressed.
	 */
	@Override
	public synchronized void actionPerformed(ActionEvent ae) {
		if (((JButton) ae.getSource()).getName().equals("start")) {
			if (server == null) {
				server = new Server(ipAdress.getText(), Integer.parseInt(port
						.getText()));
				server.start();
			}
		}
		if (((JButton) ae.getSource()).getName().equals("stop")) {
			if (server != null) {
				server.stopServer();
				server = null;
			}
		}
	}

	/**
	 * Start app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerApp();
	}
}
