package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

public class ServerApp extends ComunicatorApp {

	public ServerApp() {
		comunicatorView = new ComunicatorView(this);
		comunicator = new ReverserServer(comunicatorView);
		comunicatorView.setTitle("Reverser server app...");
	}

	public static void main(String[] args) {
		new ServerApp();
	}

}
