package com.sirma.itt.evgeni.comunication.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.comunication.MessageLogger;

public class MessageLoggerTest {

	MessageLogger messageLogger;

	/**
	 * Test log messages functions.
	 */
	@Test
	public void logMessageTtest() {
		messageLogger = new MessageLogger();
		messageLogger.logMessage("test");
		assertEquals("Messages:\ntest", messageLogger.toString());
		messageLogger.logMessage("proba");
		assertEquals("Messages:\ntest\nproba", messageLogger.toString());
	}

	/**
	 * Test acquiring next message.
	 */
	@Test
	public void getNextMessageTest() {
		messageLogger = new MessageLogger();
		messageLogger.logMessage("test");
		messageLogger.logMessage("proba");
		assertEquals("proba", messageLogger.getNextMessage());
		assertEquals("test", messageLogger.getNextMessage());
		assertEquals("", messageLogger.getNextMessage());
	}

	/**
	 * Test acquiring previous message.
	 */
	@Test
	public void getPreviousMessageTest() {
		messageLogger = new MessageLogger();
		assertEquals("", messageLogger.getPreviousMessage());
		messageLogger.logMessage("test");
		messageLogger.logMessage("proba");
		messageLogger.getNextMessage();
		messageLogger.getNextMessage();
		assertEquals("proba", messageLogger.getPreviousMessage());
		assertEquals("", messageLogger.getPreviousMessage());
	}

}
