package com.sirma.itt.evgeni.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contain information about items and their quantity.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class StockContainer implements Container {

	Map<String, Integer> items = new HashMap<String, Integer>();

	/**
	 * Update information about item.
	 */
	public void update(char operation, String description, int quantity,
			Observable obs) {
		if (operation == 'b') {

		}
	}

	/**
	 * Add quantity to store.
	 * 
	 * @param description
	 * @param quantity
	 */
	public void addQuantity(String description, int quantity) {
		if (items.containsKey(description)) {
			items.put(description, items.get(description) + quantity);
		} else {
			items.put(description, quantity);
		}
	}

	/**
	 * Remove quantity from store. Notify observers if quantity is not enough.
	 * 
	 * @param description
	 * @param quantity
	 */
	public void removeQuantity(String description, int quantity) {
		if (items.containsKey(description)) {
			items.put(description, items.get(description) + quantity);
		} else {
			items.put(description, quantity);
		}
	}

	/**
	 * Add quantity when items is in list.
	 * 
	 * @param description
	 *            determine item.
	 * @param quantity
	 *            determine how much quantity will be added. It posible to be
	 *            negative value.
	 * @param obs
	 */
	void addQuantityExsisting(char operation, String description, int quantity,
			Observable obs) {
		int qnt = items.get(description) + quantity;
		if (qnt > 0) {
			items.put(description, qnt);
		} else {
			if (qnt < 0) {
				System.out.println("Not enougth quantity!!!");
			} else {
				items.remove(description);
				obs.notifyAll('u', description, qnt);
			}
		}
	}

	/**
	 * Add item in map, when item doesn't exist.
	 * 
	 * @param description
	 *            determine item.
	 * @param quantity
	 *            determine quantity.
	 * @param obs
	 */
	void addQuantityNonExsisting(char operation, String description,
			int quantity, Observable obs) {
		if (quantity > 0) {
			items.put(description, quantity);
		}
	}

	/**
	 * Represent container as string.
	 */
	@Override
	public String toString() {
		Set<String> keys = items.keySet();
		StringBuilder stb = new StringBuilder();
		for (String key : keys) {
			stb.append("Description:");
			stb.append(key);
			stb.append(" Quantity:");
			stb.append(items.get(key));
			stb.append("\n");
		}
		return stb.toString();
	}
}
