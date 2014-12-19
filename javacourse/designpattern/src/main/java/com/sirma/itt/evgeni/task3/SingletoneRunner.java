package com.sirma.itt.evgeni.task3;

/**
 * Create singleton class. Only one instance off this class is reachable.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SingletoneRunner {

	/**
	 * Time provider return current time.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Singletone singletone = Singletone.getInstance();
		System.out.println(singletone.getTime());
	}

}
