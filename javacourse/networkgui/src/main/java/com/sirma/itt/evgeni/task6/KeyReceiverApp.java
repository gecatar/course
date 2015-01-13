package com.sirma.itt.evgeni.task6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyReceiverApp implements ActionListener {

	private KeyView view;
	private KeyReceiver receiver;

	public KeyReceiverApp() {
		view = new KeyView(this);
		receiver = new KeyReceiver();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
