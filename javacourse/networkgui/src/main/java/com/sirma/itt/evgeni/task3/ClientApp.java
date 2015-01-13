package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

/**
 * Create connection whit server.
 * 
 * @author GecaTM
 *
 */
public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		comunicatorView = new ComunicatorView(this);
		comunicator = new Client(comunicatorView);
		comunicatorView.setTitle("Client...");
	}

	public static void main(String[] args) {
		new ClientApp();
	}

}
