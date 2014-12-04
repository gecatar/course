package com.sirma.itt.evgeni.client.view;

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
	private final UserActionListener userListener;

	public ConversationPanel(UserActionListener userListener) {
		this.userListener = userListener;
		setVisible(true);
	}

	/**
	 * Add new Conversation.
	 * 
	 * @param messageListener
	 * @param name
	 */
	private void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(userListener, name);
			conversations.put(name, conversation);
			addTab(name, conversation);
		}
	}

	/**
	 * Select conversation.
	 * 
	 * @param name
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
	 * 
	 * @param name
	 *            of conversation.
	 * @param message
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
