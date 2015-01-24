package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTabbedPane;

/**
 * Create and select users conversations.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConversationPanel extends JTabbedPane {

	private final Map<String, Conversation> conversations = new HashMap<String, Conversation>();

	/**
	 * Add new Conversation.
	 */
	private void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(name, getWidth());
			conversations.put(name, conversation);
			addTab(name, conversation);
		}
	}

	/**
	 * Select conversation.
	 */
	public void selectConversation(String name) {
		if (!conversations.containsKey(name)) {
			addConversation(name);
			selectConversation(name);
		} else {
			setSelectedIndex(indexOfTab(name));
		}
	}

	/**
	 * Display message. If conversation doesn't exist first its created.
	 */
	public void showMessage(String name, String message) {
		if (conversations.containsKey(name)) {
			conversations.get(name).writeMesage(name, message);
			selectConversation(name);
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
