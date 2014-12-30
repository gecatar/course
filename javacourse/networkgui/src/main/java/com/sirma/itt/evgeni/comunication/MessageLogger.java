package com.sirma.itt.evgeni.comunication;

import java.util.ArrayList;

public class MessageLogger {

	private final ArrayList<String> messages = new ArrayList<String>();
	private int currentIndex = -1;

	public void logMessage(String message) {
		messages.add(message);
		currentIndex = message.length() - 1;
	}

	public String getNextMessage() {
		return "";
	}

	public String getPreviousMessage() {
		return "";
	}
}
