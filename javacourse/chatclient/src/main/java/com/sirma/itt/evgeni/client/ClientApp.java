package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		window = new ChatWindow(this);
		comunicator = new ClientComunicator(window);
	}
	
	public void sendMessage(String sender,String text){
		comunicator.sendMessage(sender, text);
	}

	public static void main(String[] args) {
		new ClientApp();
	}
}
