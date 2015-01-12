package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ComunicatorApp implements ActionListener, MouseListener {

	protected Comunicator comunicator;
	protected Window window;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals(
					ComponentID.CONECT_BUTTON_ID)) {
				comunicator.setName(window.getName());
				comunicator.startConection(window.getIPField(),
						window.getPort());
			}
			if (((JButton) e.getSource()).getName().equals(
					ComponentID.DISCONECT_BUTTON_ID)) {
				comunicator.stopConection();
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
