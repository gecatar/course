package com.sirma.itt.evgeni.client;

import java.util.ResourceBundle;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ChatWindow extends Window {

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
		tabbedPane.add(bundle.getString("conection_tab_name"), conectionPanel);
		tabbedPane
				.add(bundle.getString("messages_tab_name"), conversationPanel);
		tabbedPane.add(bundle.getString("user_tab_name"), userList);
		add(tabbedPane);
		setVisible(true);
	}

	public void showConversation(String name) {
		conversationPanel.selectConversation(name);
	}

	public void clearNotification(String name) {
		notifyer.removeNotification(name);
	}

	@Override
	public void setConectionStatus(MesageCommand status) {

	}

	@Override
	public void showMesage(String name, String text) {
		notifyer.addNotification(name);
	}

	@Override
	public void addUser(String name) {

	}

	@Override
	public void removeUser(String name) {

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
}
