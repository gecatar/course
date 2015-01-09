package com.sirma.itt.evgeni.task6;

/**
 * Allow interaction whit observable.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface Container {

	/**
	 * Update container.
	 */
	public void update(char operation, String description, int quantity,
			Observable obs);
}