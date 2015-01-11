package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ComunicatorRunner {

	public static void main(String[] args) {
		new ComunicatorApp(new ClientComunicator(), new ClientWindow());
	}

}
