package com.sirma.itt.evgeni.comunication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Manage starting and stooping connections.
 * 
 * @author GecaTM
 *
 */
public class ComunicatorApp implements ActionListener {

	protected Comunicator comunicator;
	protected Window window;

	/**
	 * When UI buttons are pressed.
	 */
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
}
