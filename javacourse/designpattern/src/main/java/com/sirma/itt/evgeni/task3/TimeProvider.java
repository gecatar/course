package com.sirma.itt.evgeni.task3;

/**
 * Singleton class that can have only one instance.
 * @author Evgeni Stefanov
 *
 */
public class TimeProvider {

	private static TimeProvider timeProvider = new TimeProvider();
	
	/**
	 * Private constructor.
	 */
	private TimeProvider(){
	}
	
	/**
	 * User can access instance from this function.
	 * @return
	 */
	public static TimeProvider getReference(){
		return timeProvider;
	}
	
	/**
	 * 
	 * @return current time.
	 */
	public long getTime(){
		return System.currentTimeMillis();
	}
}
