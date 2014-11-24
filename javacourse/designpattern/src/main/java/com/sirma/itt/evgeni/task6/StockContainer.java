package com.sirma.itt.evgeni.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contain information about items and their quantity.
 * @author Evgeni Stefanov
 *
 */
public class StockContainer implements Container {

	Map<String, Integer> items = new HashMap<String, Integer>();

	/**
	 * Update information about item.
	 */
	public void update(String description, int quantity, Observable obs) {

		if (quantity != 0) {
			if (items.containsKey(description)) {
				addQuantityExsisting(description, quantity, obs);
			} else {
				addQuantityNonExsisting(description, quantity, obs);
			}
		}
	}

	/**
	 * Add quantity when items is in list.
	 * @param description determine item.
	 * @param quantity determine how much quantity will be added. It posible to be negative value.
	 * @param obs
	 */
	void addQuantityExsisting(String description, int quantity, Observable obs) {
		int qnt = items.get(description) + quantity;
		if (qnt > 0) {
			items.put(description, qnt);
		} else {
			if (qnt < 0) {
				System.out.println("Not enougth quantity!!!");
			} else {
				items.remove(description);
				obs.notifyAll(description, qnt);
			}
		}
	}

	/**
	 * Add item in map, when item doesn't exist.
	 * @param description determine item.
	 * @param quantity determine quantity.
	 * @param obs
	 */
	void addQuantityNonExsisting(String description, int quantity,Observable obs) {
		if(quantity>0){
			items.put(description, quantity);
		}
	}

	/**
	 * Represent container as string.
	 */
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
