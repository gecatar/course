package com.sirma.itt.evgeni.client;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.Window;

public class MessageNotifyer {

	private final Window window;
	private ArrayList<String> notificationList = new ArrayList<String>();

	public MessageNotifyer(Window window) {
		this.window = window;
	}

	public void addNotification(String name) {
		if (!notificationList.contains(name)) {
			notificationList.add(name);
		}
		window.setTitle(getNotificationText());
	}

	public void removeNotification(String name) {
		if (notificationList.contains(name)) {
			notificationList.remove(name);
		}
		window.setTitle(getNotificationText());
	}

	private String getNotificationText() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("You have:").append(notificationList.size());
		stringBuilder.append(" new messages...");
		for (String user : notificationList) {
			stringBuilder.append("->").append(user);
		}
		return stringBuilder.toString();
	}
}
