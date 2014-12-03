package com.sirma.itt.evgeni.client.view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JTabbedPane;

public class ConverationPane extends JTabbedPane {

	Map<String, Conversation> conversations = new HashMap<String, Conversation>();

	public ConverationPane() {
		setVisible(true);
	}

	public void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(name);
			conversations.put(name, conversation);
			addTab(name, conversation);
		}
	}

	public void selectConversation(String name) {
		setSelectedIndex(indexOfTab(name));
	}

	public void displayMessage(String name, String message) {
		if (conversations.containsKey(name)) {
			conversations.get(name).writeMesage(message);
			selectConversation(name);
		} else {
			addConversation(name);
			displayMessage(name, message);
		}
	}

}
