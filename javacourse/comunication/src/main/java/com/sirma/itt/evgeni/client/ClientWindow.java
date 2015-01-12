package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientWindow extends Window {

	private JTabbedPane mainPannel;
	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;

	public ClientWindow(ComunicatorApp listener) {
		super(listener);
		setTitle("Client");
		mainPannel = new JTabbedPane();
		conectionPanel = new ConectionPanel(listener);
		conversationPanel = new ConversationPanel(listener);
		userList = new UserList(this);
		mainPannel.add("Conection", conectionPanel);
		mainPannel.add("Messages", conversationPanel);
		mainPannel.add("Users", userList);
		mainPannel.setVisible(true);
		add(mainPannel);
		setVisible(true);
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
	public void actionPerformed(ActionEvent e) {

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
