package com.sirma.itt.evgeni.client.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.client.MessageNotifyer;

/**
 * Test adding and removing names from list.
 * 
 * @author GecaTM
 *
 */
public class MessageNotifyerTest {

	private MessageNotifyer notifyer;

	@Before
	public void setUp() throws Exception {
		notifyer = new MessageNotifyer("you have", "messages");
	}

	/**
	 * Test adding names in list.
	 */
	@Test
	public void addNotificationTest() {
		notifyer.addNotification("test");
		assertEquals("you have 1 messages->test",
				notifyer.getNotificationText());
		notifyer.addNotification("test");
		assertEquals("you have 1 messages->test",
				notifyer.getNotificationText());
		notifyer.addNotification("proba");
		assertEquals("you have 2 messages->test->proba",
				notifyer.getNotificationText());
	}

	/**
	 * Test removing names from list.
	 */
	@Test
	public void removeNotificationTest() {
		notifyer.addNotification("test");
		notifyer.addNotification("proba");
		notifyer.removeNotification("proba");
		assertEquals("you have 1 messages->test",
				notifyer.getNotificationText());
	}

}
