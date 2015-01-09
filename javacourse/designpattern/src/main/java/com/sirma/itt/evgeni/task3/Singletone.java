package com.sirma.itt.evgeni.task3;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Singleton class that can have only one instance.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Singletone {

	private static final Logger LOGGER = Logger.getLogger(Singletone.class
			.getName());

	private static Singletone singletone = new Singletone();

	/**
	 * Private constructor.
	 */
	private Singletone() {
	}

	/**
	 * User can access instance from this function.
	 * 
	 * @return
	 */
	public static Singletone getInstance() {
		LOGGER.log(Level.INFO, "Instance aquired!!!");
		return singletone;
	}

	/**
	 * 
	 * @return current time.
	 */
	public long getTime() {
		return System.currentTimeMillis();
	}
}
