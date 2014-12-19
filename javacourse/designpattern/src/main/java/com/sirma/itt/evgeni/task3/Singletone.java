package com.sirma.itt.evgeni.task3;

/**
 * Singleton class that can have only one instance.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Singletone {

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
	public static Singletone getReference() {
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
