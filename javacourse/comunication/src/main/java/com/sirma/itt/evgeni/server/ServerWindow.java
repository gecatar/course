package com.sirma.itt.evgeni.server;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Display server UI.
 * 
 * @author GecaTM
 *
 */
public class ServerWindow extends Window {

	private ConectionPanel conectionPanel;

	public ServerWindow(ComunicatorApp listener) {
		super(listener);
		setTitle("Server");
		conectionPanel = new ConectionPanel(listener);
		add(conectionPanel);
		setVisible(true);
	}

	/**
	 * Return displayed IP.
	 */
	@Override
	public String getIPField() {
		return conectionPanel.getIP();
	}

	/**
	 * Return displayed port.
	 */
	@Override
	public int getPort() {
		return conectionPanel.getPort();
	}

	@Override
	public void setConectionStatus(MesageCommand status) {
		if (status == MesageCommand.USER_LOG_IN) {
			conectionPanel.displayMessage("User logged on server");
		}
		if (status == MesageCommand.USER_LOG_OUT) {
			conectionPanel.displayMessage("User logged off from server");
		}
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
	public String getName() {
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

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
