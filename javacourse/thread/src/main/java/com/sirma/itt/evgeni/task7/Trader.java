package com.sirma.itt.evgeni.task7;

/**
 * Trader class that will be extended from byers and sellers.
 * @author Evgeni Stefanov
 *
 */
public class Trader extends Thread {

	Store store;
	String description;
	int quantity;

	/**
	 * Set up parameters for item description and quantity.
	 * @param description
	 * @param quantity
	 */
	public void setValues(String description, int quantity) {
		this.description = description;
		this.quantity = quantity;
	}

	public Trader(Store store, String description, int quantity) {
		this.store = store;
		this.description = description;
		this.quantity = quantity;
	}

	public void run() {

	}

}