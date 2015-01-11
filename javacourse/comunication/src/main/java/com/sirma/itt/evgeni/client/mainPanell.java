package com.sirma.itt.evgeni.client;

import javax.swing.JTabbedPane;

/**
 * Contain all UI elements.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class mainPanell extends JTabbedPane {

	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;

	public mainPanell(ClientWindow listener) {
		conectionPanel = new ConectionPanel(listener);
		conversationPanel = new ConversationPanel(listener);
		userList = new UserList(listener);

		add("Conection", conectionPanel);
		add("Messages", conversationPanel);
		add("Users", userList);
		setVisible(true);
	}
}
