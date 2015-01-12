package com.sirma.itt.evgeni.server;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

public class ServerApp extends ComunicatorApp {

	public ServerApp() {
		window = new ServerWindow(this);
		comunicator = new ServerComunicator(window);
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
	}

	public static void main(String[] args) {
		new ServerApp();
	}
}
