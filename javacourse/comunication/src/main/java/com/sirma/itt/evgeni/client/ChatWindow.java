package com.sirma.itt.evgeni.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ChatWindow extends Window {

	public ChatWindow(ComunicatorApp listener) {
		super(listener);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		JPanel panel = new JPanel(new GridBagLayout());
		add(panel);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		panel.add(new JLabel("IP"), gridBagConstraints);
		setVisible(true);
	}

	@Override
	public void setConectionStatus(MesageCommand status) {

	}

	@Override
	public void showMesage(String name, String text) {

	}

	@Override
	public void addUser(String name) {

	}

	@Override
	public void removeUser(String name) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

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

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getIPField() {
		return null;
	}

	@Override
	public int getPort() {
		return 0;
	}

	@Override
	public String getMessageText(String name) {
		return null;
	}

}
