package com.sirma.itt.evgeni.client;

import java.util.ArrayList;

import com.sirma.itt.evgeni.comunication.Window;

public class MessageNotifyer {

	private final ArrayList<String> notificationList = new ArrayList<String>();
	private final Window window;

	public MessageNotifyer(Window window) {
		this.window = window;
	}

	public void showNotification(String name) {
		if (addNotification(name)) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You have:").append(notificationList.size());
			stringBuilder.append(" new messages...");
			for (String user : notificationList) {
				stringBuilder.append("->").append(user);
			}
		}
	}

	private boolean addNotification(String name) {
		if (!notificationList.contains(name)) {
			notificationList.add(name);
			return true;
		}
		return false;
	}
}
