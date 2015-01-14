package com.sirma.itt.evgeni.task7;

/**
 * Trader class that will be extended from byers and sellers.
 * 
 * @author Evgeni Stefanov
 *
 */
public class Trader extends Thread {

	protected Store store;
	protected String description;
	protected int quantity;

	public Trader(Store store, String description, int quantity) {
		this.store = store;
		this.description = description;
		this.quantity = quantity;
	}
}