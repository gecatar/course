package com.sirma.itt.evgeni.task6;
/**
 * Specify Observable functions.
 * @author Evgeni Stefanov
 *
 */
public interface Observable {

	public void addObserver(Container container);
	public void notifyAll(String description,int quantity);
	public void buyItem(String description, int quantity);
	public void sellItem(String description, int quantity);
	
}
