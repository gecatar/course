package com.sirma.itt.evgeni.task7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manage byers and sellers. Suspend threads that can`t complete actions.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Store {

	private Map<String, Integer> stocks = new HashMap<String, Integer>();
	private int capacity;

	public Store(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Add items in store.
	 * 
	 * @param description
	 *            describe unit
	 * @param quantity
	 *            determine how much quantity will be added.
	 * @throws InterruptedException
	 *             when suspended thread be interrupted.
	 */
	public synchronized void addStock(String description, int quantity) {

		if (stocks.containsKey(description)) {
			int temp = stocks.get(description);
			temp += quantity;
			if (temp < capacity) {
				stocks.put(description, temp);
				notifyAll();
			} else {
				try {
					wait();
					addStock(description, quantity);
				} catch (InterruptedException e) {
					System.out.println("Thread interupted...");
				}

			}
		} else {
			if (quantity < capacity) {
				stocks.put(description, quantity);
				notifyAll();
			} else {
				try {
					wait();
					addStock(description, quantity);
				} catch (InterruptedException e) {
					System.out.println("Thread interupted...");
				}
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
			int temp = stocks.get(description);
			temp -= quantity;
			if (temp >= 0) {
				stocks.put(description, temp);
				notifyAll();
			} else {
				try {
					wait();
					removeStock(description, quantity);
				} catch (InterruptedException e) {
					System.out.println("Thread interupted...");
				}
			}
		} else {
			System.out.println("Not avaible...!!!");
		}
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
		return stb.toString();
	}
}