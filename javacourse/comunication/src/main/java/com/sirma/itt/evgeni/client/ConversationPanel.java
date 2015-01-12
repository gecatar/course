package com.sirma.itt.evgeni.client;

import java.awt.event.ActionListener;
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
	private ActionListener listener;

	public ConversationPanel(ActionListener listener) {
		this.listener = listener;
		setVisible(true);
	}

	public String getTextFieldText(String name) {
		return conversations.get(name).getTextFieldText();
	}

	/**
	 * Add new Conversation.
	 */
	private void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(listener, name);
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
	public void displayMessage(String name, String message) {
		if (conversations.containsKey(name)) {
			conversations.get(name).writeMesage(name, message);
			selectConversation(name);
		} else {
			addConversation(name);
			displayMessage(name, message);
		}
	}
}
