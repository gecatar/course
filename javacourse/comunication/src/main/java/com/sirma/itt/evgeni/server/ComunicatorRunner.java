package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ComunicatorRunner {

	public static void main(String[] args) {
		new ComunicatorApp(new ServerComunicator(), new ServerWindow());
	}
}
