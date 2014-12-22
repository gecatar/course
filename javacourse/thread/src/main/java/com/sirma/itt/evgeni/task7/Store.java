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
	 * Add stock.
	 * 
	 * @param description
	 * @param quantity
	 */
	public synchronized void addStock(String description, int quantity) {
		if (quantity <= freeSpace) {
			updateQuantity(description, quantity);
			freeSpace -= quantity;
			notifyAll();
		} else {
			try {
				wait();
				addStock(description, quantity);
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupted", e);
			}
		}
	}

	/**
	 * Remove items from store. If operation is not successful suspend thread.
	 * 
	 * @param description
	 *            of item
	 * @param quantity
	 *            of item that will be removed.
	 * @throws InterruptedException
	 *             when thread is interrupted.
	 */
	public synchronized void removeStock(String description, int quantity) {
		if (stocks.containsKey(description)) {
			if (stocks.get(description) >= quantity) {
				updateExistingtem(description, quantity * -1);
				freeSpace += quantity;
				notifyAll();
				return;
			}
		}
		try {
			wait();
			removeStock(description, quantity);
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "Thread interupdet", e);
		}

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