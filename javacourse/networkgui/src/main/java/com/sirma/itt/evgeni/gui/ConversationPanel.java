package com.sirma.itt.evgeni.gui;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 * Create and select users conversations.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConversationPanel extends JTabbedPane {

	private static final Icon userOnlineIcon = new ImageIcon(
			ConversationPanel.class.getResource("/user-green-icon.png"));
	private static final Icon userOflineIcon = new ImageIcon(
			ConversationPanel.class.getResource("/user-red-icon.png"));
	private static final Icon checkedMessageIcon = new ImageIcon(
			ConversationPanel.class.getResource("/mail-check-icon.png"));
	private static final Icon newMessageIcon = new ImageIcon(
			ConversationPanel.class.getResource("/mail-icon.png"));

	public ConversationPanel() {
		addTab("Status", new StatusTab());
	}

	public void showConectionStatusIcon(Conversation conversation) {
		if (conversation.isConected()) {
			showOnlineIcon(conversation);
		} else {
			showOfflineIcon(conversation);
		}
	}

	public void showOnlineIcon(Conversation conversation) {
		setIconAt(indexOfTabComponent(conversation), userOnlineIcon);
	}

	public void showOfflineIcon(Conversation conversation) {
		setIconAt(indexOfTabComponent(conversation), userOflineIcon);
	}

	public void showCheckedMessageIcon(Conversation conversation) {
		setIconAt(indexOfTabComponent(conversation), checkedMessageIcon);
	}

	public void showNewMessageIcon(Conversation conversation) {
		setIconAt(indexOfComponent(conversation), newMessageIcon);
	}

	/**
	 * Close active conversation.
	 */
	public void closeActiveConversation() {
		Component temp = getComponent(getSelectedIndex());
		remove(temp);
	}

	/**
	 * Close all conversations.
	 */
	public void closeAllConversation() {
		removeAll();
	}
}
