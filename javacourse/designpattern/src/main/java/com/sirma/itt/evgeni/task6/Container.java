package com.sirma.itt.evgeni.task6;

/**
 * Allow interaction whit observable.
 * 
 * @author Evgeni Stefanov
 * 
 */
public interface Container {

	public void update(char operation, String description, int quantity,
			Observable obs);

	public String toString();
}