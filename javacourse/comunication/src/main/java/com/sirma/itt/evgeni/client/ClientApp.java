package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		comunicator = new ClientComunicator();
		window = new ClientWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				comunicator.startConection(window.getIPField(),
						window.getPort());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				comunicator.stopConection();
			}
		}
		if (e.getSource().getClass() == JTextField.class) {
			JTextField temp = (JTextField) e.getSource();
			window.displayMessage(temp.getName(),
					window.getMessageText(temp.getName()));
		}
	}

	public static void main(String[] args) {
		new ClientApp();
	}
}
