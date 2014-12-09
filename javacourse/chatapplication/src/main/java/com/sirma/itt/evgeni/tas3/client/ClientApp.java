package com.sirma.itt.evgeni.tas3.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientApp implements ComunicatorListener, ActionListener {

	Comunicator comunicator;

	public ClientApp() {
		JPanel conectionPanel = new JPanel();
		conectionPanel
				.setLayout(new BoxLayout(conectionPanel, BoxLayout.Y_AXIS));
		JButton startConection = new JButton("Conect");
		startConection.setName("StartConection");
		startConection.addActionListener(this);
		JButton stopConection = new JButton("Disconect");
		stopConection.setName("StopConection");
		stopConection.addActionListener(this);
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		conectionPanel.add(startConection);
		conectionPanel.add(stopConection);
		new Window(conectionPanel);
	}

	@Override
	public void setConectionStatus(String conectionCondition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMesage(String name, String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String name) {
		// TODO Auto-generated method stub

	}

	// Runner--------------------------------
	public static void main(String[] args) {
		ClientApp clientApp = new ClientApp();
		// comunicator = new Client(clientApp);
	}

	// --------------------------------------

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
