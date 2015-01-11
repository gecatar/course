package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.sirma.itt.evgeni.comunication.Window;

public class ClientWindow extends Window implements ActionListener,
		MouseListener {

	public ClientWindow() {
		setTitle("Client");
		add(new mainPanell(this));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				// userListener.startConection(nickname.getText(),
				// ipAdress.getText(), port.getText());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				// userListener.stopConection();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
