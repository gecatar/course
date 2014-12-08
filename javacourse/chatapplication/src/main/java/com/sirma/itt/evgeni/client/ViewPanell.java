package com.sirma.itt.evgeni.client;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.UILIstener;

/**
 * Contain all UI elements.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ViewPanell extends JTabbedPane implements UserActionListener {

	ConectionPanel conectionPanel;
	ConversationPanel conversationPanel;
	UserList userList;
	UILIstener uiListener;

	public ViewPanell(UILIstener uiListener) {

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
		setSelectedComponent(conversationPanel);
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
		setSelectedIndex(indexOfComponent(conversationPanel));
		conversationPanel.selectConversation(name);
	}

	public void setConectionStatus(String conectionCondition) {
		conectionPanel.setConectionStatus(conectionCondition);
	}

	/**
	 * Start connection.
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
