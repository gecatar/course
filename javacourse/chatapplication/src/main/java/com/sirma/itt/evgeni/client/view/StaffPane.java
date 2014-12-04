package com.sirma.itt.evgeni.client.view;

import javax.swing.JTabbedPane;

public class StaffPane extends JTabbedPane implements UserActionListener {

	ConectionPanel conectionPanel;
	ConversationPanel conversationPanel;
	UserList userList;
	UILIstener uiListener;

	public StaffPane(UILIstener uiListener) {

		this.uiListener = uiListener;
		conectionPanel = new ConectionPanel(this);
		conversationPanel = new ConversationPanel(this);
		userList = new UserList(this);

		add("Conection", conectionPanel);
		add("Messages", conversationPanel);
		add("Users", userList);
	}

	public void displayMessage(String name, String message) {
		conversationPanel.displayMessage(name, message);
	}

	public void addUser(String name) {
		userList.addUser(name);
	}

	public void removeUser(String name) {
		userList.removeUser(name);
	}

	public void sendMessage(String name, String message) {
		uiListener.sendMessage(name, message);
	}

	public void userSelected(String name) {
		conversationPanel.selectConversation(name);
	}

	public void startConection(String nickname, String ip, String port) {
		uiListener.startConection(nickname, ip, port);
	}

	public void stopConection() {
		uiListener.stopConection();
	}
}
