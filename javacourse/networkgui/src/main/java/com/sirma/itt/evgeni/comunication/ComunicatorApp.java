package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ComunicatorApp implements ActionListener {

	protected Comunicator comunicator;
	protected ComunicatorView comunicatorView;

	/**
	 * When UI Button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource()) instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getName().equals("start")) {
				comunicator.startConection(comunicatorView.getIP(),
						comunicatorView.getPort());
			}
			if (button.getName().equals("stop")) {
				comunicator.stopConection();
			}

		}
	}
}
