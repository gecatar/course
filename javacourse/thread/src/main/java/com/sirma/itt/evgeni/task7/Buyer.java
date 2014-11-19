package com.sirma.itt.evgeni.task7;

/**
 * Manage incoming items.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Buyer extends Trader {

	public Buyer(Store store, String description, int quantity) {
		super(store, description, quantity);
	}

	/**
	 * Add stocks to store.
	 */
	public void run() {
		store.addStock(description, quantity);
	}
}
