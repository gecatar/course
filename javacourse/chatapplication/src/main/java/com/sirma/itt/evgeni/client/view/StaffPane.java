package com.sirma.itt.evgeni.client.view;

import javax.swing.JTabbedPane;

/**
 * Contain all UI elements.
 * 
 * @author Evgeni Stefanov
 * 
 */
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

	/**
	 * Display message.
	 * 
	 * @param name
	 * @param message
	 */
	public void displayMessage(String name, String message) {
		conversationPanel.displayMessage(name, message);
	}

	/**
	 * Add user in users list.
	 * 
	 * @param name
	 */
	public void addUser(String name) {
		userList.addUser(name);
	}

	/**
	 * Remove user from users list.
	 * 
	 * @param name
	 */
	public void removeUser(String name) {
		userList.removeUser(name);
	}

	/**
	 * Send message.
	 */
	public void sendMessage(String name, String message) {
		uiListener.sendMessage(name, message);
	}

	/**
	 * Highlight user name.
	 */
	public void userSelected(String name) {
		conversationPanel.selectConversation(name);
	}

	/**
	 * Start conection.
	 */
	public void startConection(String nickname, String ip, String port) {
		uiListener.startConection(nickname, ip, port);
	}

	/**
	 * Stop connection.
	 */
	public void stopConection() {
		uiListener.stopConection();
	}
}
