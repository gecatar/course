package com.sirma.itt.evgeni.task7;

/**
 * Manage sales.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Seller extends Trader {

	public Seller(Store store, String description, int quantity) {
		super(store, description, quantity);
	}

	/**
	 * Execute sales.
	 */
	@Override
	public void run() {
		store.sellStock(description, quantity);
	}
}