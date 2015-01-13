package com.sirma.itt.evgeni.task5;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;

/**
 * Create connection and read message.
 * 
 * @author GecaTM
 *
 */
public class ClientApp extends ComunicatorApp {

	public ClientApp() {
		comunicatorView = new ReverserView(this);
		comunicator = new ReverserClient(comunicatorView);
		comunicatorView.setTitle("Reverse client app...");
	}

	/**
	 * Sending message event.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() instanceof JTextField) {
			comunicator.sendMessage(comunicatorView.getText());
		}
	}

	public static void main(String[] args) {
		new ClientApp();
	}

}
