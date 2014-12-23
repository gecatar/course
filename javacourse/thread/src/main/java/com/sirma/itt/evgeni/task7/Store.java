package com.sirma.itt.evgeni.task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manage byers and sellers. Suspend threads that can`t complete actions.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Store {

	private static final Logger LOGGER = Logger
			.getLogger(Store.class.getName());
	private Map<String, Integer> stocks = new HashMap<String, Integer>();
	private int freeSpace;

	public Store(int capacity) {
		freeSpace = capacity;
	}

	public int getFreeSpace() {
		return freeSpace;
	}

	/**
	 * Add items in store. If operation is not successful suspend thread.
	 * 
	 * @param description
	 * @param quantity
	 */
	public synchronized void buyStock(String description, int quantity) {
		while (!addStock(description, quantity)) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupdet", e);
			}
		}
		notifyAll();
	}

	/**
	 * Remove items from store. If operation is not successful suspend thread.
	 * 
	 * @param description
	 * @param quantity
	 */
	public synchronized void sellStock(String description, int quantity) {
		while (!removeStock(description, quantity)) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupdet", e);
			}
		}
		notifyAll();
	}

	private synchronized boolean addStock(String description, int quantity) {
		if (quantity <= freeSpace) {
			updateQuantity(description, quantity);
			freeSpace -= quantity;
			return true;
		} else {
			return false;
		}
	}

	private boolean removeStock(String description, int quantity) {
		if (stocks.containsKey(description)) {
			if (stocks.get(description) >= quantity) {
				updateQuantity(description, quantity * -1);
				freeSpace += quantity;
				return true;
			}
		}
		return false;
	}

	private void updateQuantity(String description, int quantity) {
		if (stocks.containsKey(description)) {
			updateExistingtem(description, quantity);
		} else {
			updateNotExistingtem(description, quantity);
		}
	}

	private void updateExistingtem(String description, int quantity) {
		int temp = stocks.get(description);
		stocks.put(description, quantity + temp);
	}

	private void updateNotExistingtem(String description, int quantity) {
		stocks.put(description, quantity);
	}

	/**
	 * Visual representation of all items.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		Set<String> keys = stocks.keySet();
		for (String key : keys) {
			stb.append("Description:");
			stb.append(key);
			stb.append(" Quantity:");
			stb.append(stocks.get(key));
			stb.append("\n");
		}
		return stb.toString().trim();
	}
}