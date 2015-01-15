package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

/**
 * Create connections whit clients.
 * 
 * @author GecaTM
 *
 */
public class ServerApp extends ComunicatorApp {

	public ServerApp() {
		window = new ServerWindow(this);
		comunicator = new ServerComunicator(window);
	}

	public static void main(String[] args) {
		new ServerApp();
	}
}
