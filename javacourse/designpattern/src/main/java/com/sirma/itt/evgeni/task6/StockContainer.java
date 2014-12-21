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
			addQuantity(description, quantity);
		}
		if (operation == 's') {
			removeQuantity(description, quantity, obs);
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
	public void removeQuantity(String description, int quantity, Observable obs) {
		if (items.containsKey(description)) {
			int unAvaibleQuantity = quantity - items.get(description);
			if (unAvaibleQuantity > 0) {
				obs.notifyAll('u', description, unAvaibleQuantity);
				items.put(description, 0);
			} else {
				addQuantity(description, quantity * -1);
			}
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
