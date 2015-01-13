package com.sirma.itt.evgeni.task6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JButton;

public class KeyTransmiterApp implements ActionListener {

	private KeyTransmiterView view;
	private KeyTransmiter transmiter;

	public KeyTransmiterApp() {
		view = new KeyTransmiterView(this);
	}

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

		}
	}

	private void sendSmallPackage() {
		if (transmiter != null) {
			transmiter.send(new byte[8]);
		}
	}

	private void sendBigPackage() {
		if (transmiter != null) {
			transmiter.send(new byte[32]);
		}
	}

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
