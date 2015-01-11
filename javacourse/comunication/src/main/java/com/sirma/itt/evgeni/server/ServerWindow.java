package com.sirma.itt.evgeni.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sirma.itt.evgeni.comunication.Window;

public class ServerWindow extends Window implements ActionListener {

	private ConectionPanel conectionPanel;

	public ServerWindow() {
		setTitle("Server");
		conectionPanel = new ConectionPanel(this);
		add(conectionPanel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				listener.startConection("server", conectionPanel.getIP(),
						conectionPanel.getPort());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				listener.stopConection();
			}
		}
	}
}
