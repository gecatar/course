package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

public class InfoServerApp extends ComunicatorApp {

	public InfoServerApp() {
		comunicatorView = new ComunicatorView(this);
		comunicator = new InfoReaderServer(comunicatorView);
		comunicatorView.setTitle("Info server app...");
	}

	public static void main(String[] args) {
		new InfoServerApp();
	}

}
