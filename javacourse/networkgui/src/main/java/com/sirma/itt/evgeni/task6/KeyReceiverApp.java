package com.sirma.itt.evgeni.task6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KeyReceiverApp implements ActionListener {

	private KeyView view;
	private KeyReceiver receiver;

	public KeyReceiverApp() {
		view = new KeyView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getName().equals("start")) {
				if (receiver == null) {
					receiver = new KeyReceiver(view, view.ipAdress.getText(),
							Integer.parseInt(view.port.getText()),
							Integer.parseInt(view.datagramSize.getText()));
					receiver.start();
				}
			}
		}
	}

	public static void main(String[] args) {
		new KeyReceiverApp();
	}
}
