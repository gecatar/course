package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		window = new ClientWindow(this);
		comunicator = new ClientComunicator(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource().getClass() == JTextField.class) {
			JTextField temp = (JTextField) e.getSource();
			comunicator.sendMessage(temp.getName(),
					window.getMessageText(temp.getName()));
		}
	}

	public static void main(String[] args) {
		new ClientApp();
	}
}
