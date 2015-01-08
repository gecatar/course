package com.sirma.itt.evgeni.comunication;

import java.util.ArrayList;

public class MessageLogger {

	private final ArrayList<String> messages = new ArrayList<String>();
	private int currentIndex = -1;

	public void logMessage(String message) {
		if (!messages.contains(message)) {
			messages.add(message);
			currentIndex = messages.size();
		}
	}

	public String getNextMessage() {
		if (containIndex(currentIndex - 1)) {
			currentIndex--;
			return messages.get(currentIndex);
		} else {
			currentIndex = -1;
			return "";
		}
	}

	public String getPreviousMessage() {
		if (containIndex(currentIndex + 1)) {
			currentIndex++;
			return messages.get(currentIndex);
		} else {
			currentIndex = messages.size();
			return "";
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Messages:").append("\n");
		for (String message : messages) {
			stringBuilder.append(message).append("\n");
		}
		return stringBuilder.toString().trim();
	}

	private boolean containIndex(int index) {
		return (index >= 0 && index < messages.size());
	}
}
