package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		window = new ChatView(this);
		comunicator = new ClientComunicator(window);
	}

	public void sendSeenNotification(String sender) {

	}

	public void sendMessage(String sender, String text) {
		comunicator.sendMessage(sender, text);
	}

	public static void main(String[] args) {
		new ClientApp();
	}
}
