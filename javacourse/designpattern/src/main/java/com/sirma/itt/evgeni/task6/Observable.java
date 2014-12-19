package com.sirma.itt.evgeni.task6;

/**
 * Specify Observable functions.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface Observable {

	public void addObserver(Container container);

	public void notifyAll(char operation, String description, int quantity);

}
