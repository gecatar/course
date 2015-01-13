package com.sirma.itt.evgeni.task6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JButton;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Transmit keys.
 * 
 * @author GecaTM
 *
 */
public class KeyTransmiterApp implements ActionListener {

	private static final Logger LOGGER = Logger
			.getLogger(KeyTransmiterApp.class.getName());
	private KeyTransmiterView view;
	private KeyTransmiter transmiter;

	public KeyTransmiterApp() {
		view = new KeyTransmiterView(this);
	}

	/**
	 * Start transmitter.
	 */
	private void startTransmiter() {
		try {
			DatagramTransmiter firstDatagramTransmiter = new DatagramTransmiter(
					view.ipAdress.getText(), Integer.parseInt(view.port
							.getText()));
			DatagramTransmiter secondDatagramTransmiter = new DatagramTransmiter(
					view.ipAdressSecond.getText(),
					Integer.parseInt(view.portSecond.getText()));
			firstDatagramTransmiter.conect();
			secondDatagramTransmiter.conect();
			transmiter = new KeyTransmiter(firstDatagramTransmiter,
					secondDatagramTransmiter);
		} catch (UnknownHostException e) {
			LOGGER.log(Level.ERROR, "Error when creating transmiter.", e);
		}
	}

	/**
	 * Send small package.
	 */
	private void sendSmallPackage() {
		if (transmiter != null) {
			transmiter.send(new byte[8]);
		}
	}

	/**
	 * Send big package.
	 */
	private void sendBigPackage() {
		if (transmiter != null) {
			transmiter.send(new byte[32]);
		}
	}

	/**
	 * When button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getName().equals("8BIT")) {
				sendSmallPackage();
			}
			if (button.getName().equals("32BIT")) {
				sendBigPackage();
			}
			if (button.getName().equals("start")) {
				startTransmiter();
			}
		}
	}

	public static void main(String[] args) {
		new KeyTransmiterApp();
	}
}
