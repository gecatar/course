package com.sirma.itt.evgeni.task4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.ComunicatorView;

/**
 * Read and display information about clients.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class InfoReaderApp extends ComunicatorView implements ActionListener,
		ComunicatorListener {

	ClientInfoReader infoReader;

	public InfoReaderApp() {
		this.setTitle("ClientInfoReader");
	}

	/**
	 * When UI Button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}

	/**
	 * Start app.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new InfoReaderApp();
	}

	@Override
	public void userConected() {
	}

	/**
	 * Display message from server.
	 */
	@Override
	public void displayMessage(String message) {
		// messageArea.setText(message + "\n" + messageArea.getText());
	}

	/**
	 * When connection state change.
	 */
	@Override
	public void conectionStatusChange(boolean conected) {
		if (conected) {
			conectionStatus.setText("Conected...!!!");
		} else {
			conectionStatus.setText("Disconected...!!!");
		}

	}

}
