package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

/**
 * Create connection and read message.
 * 
 * @author GecaTM
 *
 */
public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		comunicatorView = new ReverserView(this);
		comunicator = new ReverserClient(comunicatorView);
		comunicatorView.setTitle("Reverse client app...");
	}

	public static void main(String[] args) {
		new ClientApp();
	}

}
