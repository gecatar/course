package com.sirma.itt.evgeni.task4;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

public class InfoClientApp extends ComunicatorApp {

	public InfoClientApp() {
		comunicatorView = new ComunicatorView(this);
		comunicator = new InfoReaderClient(comunicatorView);
		comunicatorView.setTitle("Client info app...");
	}

	public static void main(String[] args) {
		InfoClientApp app = new InfoClientApp();

	}

}
