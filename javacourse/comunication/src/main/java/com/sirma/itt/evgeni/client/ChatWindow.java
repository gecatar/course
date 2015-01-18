package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ChatWindow extends Window implements ActionListener, MouseListener {

	private final JTabbedPane tabbedPane = new JTabbedPane();
	private final ConectionPanel conectionPanel;
	private final ConversationPanel conversationPanel;
	private final UserList userList;
	private final MessageNotifyer notifyer;
	private ResourceBundle bundle;
	private String USER_CONECTED_MESSAGE;
	private String USER_DISCONECTED_MESSAGE;
	private String USERNAME_BISY_MESSAGE;

	public ChatWindow(ClientApp listener) {
		super(listener);
		bundle = ResourceBundle.getBundle("test");
		conectionPanel = new ConectionPanel(listener, bundle);
		conversationPanel = new ConversationPanel(this);
		userList = new UserList(this);
		notifyer = new MessageNotifyer(this);
		add(tabbedPane);
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
	public String getName() {
		return conectionPanel.getName();
	}

	@Override
	public String getIPField() {
		return conectionPanel.getIP();
	}

	@Override
	public int getPort() {
		return conectionPanel.getPort();
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
