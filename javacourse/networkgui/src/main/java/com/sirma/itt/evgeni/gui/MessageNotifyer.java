package com.sirma.itt.evgeni.gui;

import java.util.ArrayList;

/**
 * Contain list whit new messages.
 * 
 * @author GecaTM
 *
 */
public class MessageNotifyer {

	private final ArrayList<String> notificationList = new ArrayList<String>();
	private String youHaveMessage;
	private String messageMessage;

	public boolean hasNotifications(String name) {
		return notificationList.contains(name);
	}

	/**
	 * Add notification.
	 */
	public void addNotification(String name) {
		if (!notificationList.contains(name)) {
			notificationList.add(name);
		}
	}

	/**
	 * Remove notification.
	 */
	public void removeNotification(String name) {
		if (notificationList.contains(name)) {
			notificationList.remove(name);
		}
	}

	/**
	 * Get notification text.
	 */
	public String getNotificationText() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(youHaveMessage + " ").append(
				notificationList.size());
		stringBuilder.append(" " + messageMessage);
		for (String user : notificationList) {
			stringBuilder.append("->").append(user);
		}
		return stringBuilder.toString();
	}
}
