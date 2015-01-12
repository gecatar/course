package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.Window;

public class ClientWindow extends Window implements ActionListener,
		MouseListener {

	private JTabbedPane mainPannel;
	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;

	public ClientWindow() {
		setTitle("Client");
		mainPannel = new JTabbedPane();
		conectionPanel = new ConectionPanel(this);
		conversationPanel = new ConversationPanel(this);
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
	public void actionPerformed(ActionEvent e) {

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

}
