package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

/**
 * Create incoming connections and send data.
 * 
 * @author GecaTM
 *
 */
public class ServerApp extends ComunicatorApp {

	public ServerApp() {
		comunicatorView = new ComunicatorView(this);
		comunicator = new Server(comunicatorView);
		comunicatorView.setTitle("Server...");
	}

	public static void main(String[] args) {
		new ServerApp();
	}

}
