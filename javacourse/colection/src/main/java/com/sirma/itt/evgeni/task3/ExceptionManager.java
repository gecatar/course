package com.sirma.itt.evgeni.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Store exception log. Save different type error using codes or strings. Allow
 * adding new error codes and their descriptions.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ExceptionManager {

	private static final Logger LOGGER = Logger
			.getLogger(ExceptionManager.class.getName());
	private static final String SEPARATOR = new String("|");
	private static Map<String, String> exceptions = new HashMap<String, String>();
	private String message = "";
	static {
		exceptions.put("INVID", "Invalid UID");
		exceptions.put("INVPC", "Invalid Post Code");
		exceptions.put("INVDC", "Invalid Debit Card Number");
	}

	/**
	 * Split main string into Array whit strings containing all errors saved to
	 * the moment of invocation.
	 */
	public List<String> getMesages(String msg) {
		return Arrays.asList(msg.split("\\" + SEPARATOR));
	}

	/**
	 * Return message.
	 */
	public String getMesage() {
		return message;
	}

	/**
	 * Clear saved errors.
	 */
	public void clearLog() {
		message = "";
	}

	/**
	 * Add message to string whit all messages. Separated whit constant
	 * separator.
	 */
	public void addExceptionMesage(String mess) {
		if (exceptions.containsValue(mess)) {
			message += mess;
			message += SEPARATOR;
		}
	}

	/**
	 * Add key and description to Map of exception.
	 */
	public void addExceptionAndDescription(String key, String description) {
		exceptions.put(key, description);
	}

	/**
	 * List all keys.
	 */
	public Set<String> getKeys() {
		return exceptions.keySet();
	}

	/**
	 * Add exception whit key. Message is extracted from Map.
	 */
	public void addExceptionUsingCode(String key) {
		if (exceptions.containsKey(key)) {
			message += exceptions.get(key);
			message += SEPARATOR;
		} else {
			LOGGER.log(Level.INFO, "Error code not suported!!!");
		}
	}
}
