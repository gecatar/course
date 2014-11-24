package com.sirma.itt.evgeni.task3;


/**
 * Create singleton class. Only one instance off this class is reachable.
 * @author Evgeni Stefanov
 *
 */
public class TimeProviderRunner {

	/**
	 * Time provider return current time.
	 * @param args
	 */
	public static void main(String[] args) {
		TimeProvider time = TimeProvider.getReference();
		System.out.println(time.getTime());
	}

}
