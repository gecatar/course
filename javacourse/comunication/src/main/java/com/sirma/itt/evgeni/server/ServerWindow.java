package com.sirma.itt.evgeni.server;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ServerWindow extends Window {

	private ConectionPanel conectionPanel;

	public ServerWindow(ComunicatorApp listener) {
		super(listener);
		setTitle("Server");
		conectionPanel = new ConectionPanel(listener);
		add(conectionPanel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getIPField() {
		return "localhost";
	}

	@Override
	public int getPort() {
		return 7005;
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
	public String getMessageText(String name) {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
