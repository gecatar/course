package com.sirma.itt.evgeni.task6;

/**
 * Specify Observable functions.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface Observable {

	/**
	 * Add observer.
	 */
	public void addObserver(Container container);

	/**
	 * Notify all observers.
	 */
	public void notifyAll(char operation, String description, int quantity);

}
