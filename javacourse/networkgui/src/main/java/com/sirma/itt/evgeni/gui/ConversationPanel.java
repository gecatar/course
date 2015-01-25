package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

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
	private final Map<String, Conversation> conversations = new HashMap<String, Conversation>();

	public ConversationPanel() {
		addTab("Status", new StatusTab(getHeight()));
	}

	public void updateUserStatus(String name, boolean conected) {
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			conversation.setConected(conected);
			// if(messageNotifier).....ConversationPanel.
			setStatus(conversation, conected);
		}
	}

	public void setStatus(Conversation conversation, boolean conected) {
		if (conected) {
			setIconAt(indexOfComponent(conversation), userOnlineIcon);
		} else {
			setIconAt(indexOfComponent(conversation), userOflineIcon);
		}
	}

	public void clearNotification(String name) {
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			setStatus(conversation, conversation.isConected());
		}
	}

	/**
	 * Add new Conversation.
	 */
	private void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(name);
			conversations.put(name, conversation);
			addTab(name, conversation);
		}
	}

	/**
	 * Select conversation.
	 */
	public void showConversation(String name) {
		if (!conversations.containsKey(name)) {
			addConversation(name);
			showConversation(name);
		} else {
			setSelectedComponent(conversations.get(name));
		}
	}

	/**
	 * Display message. If conversation doesn't exist first its created.
	 */
	public void showMessage(String name, String message) {
		if (conversations.containsKey(name)) {
			conversations.get(name).writeMesage(name, message);
			setIconAt(indexOfComponent(conversations.get(name)), newMessageIcon);
			showConversation(name);
		} else {
			addConversation(name);
			showMessage(name, message);
		}
	}

	/**
	 * Close active conversation.
	 */
	public void closeActiveConversation() {
		Component temp = getComponent(getSelectedIndex());
		conversations.remove(temp.getName());
		remove(temp);
	}

	/**
	 * Close all conversations.
	 */
	public void closeAllConversation() {
		conversations.clear();
		removeAll();
	}
}
