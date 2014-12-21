package com.sirma.itt.evgeni.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contain information about items which are not available.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SoldContainer implements Container {

	Map<String, Integer> items = new HashMap<String, Integer>();

	/**
	 * If quantity is zero add item in list.
	 */
	public void update(char operation, String description, int quantity,
			Observable obs) {
		if (operation == 's') {
			registerSale(description, quantity);
		}
		if (operation == 'u') {
			rollbackSale(description, quantity);
		}
	}

	/**
	 * Roll back quantity.
	 * 
	 * @param description
	 * @param quantity
	 */
	public void rollbackSale(String description, int quantity) {
		registerSale(description, quantity * -1);
	}

	/**
	 * Register sold quantity.
	 * 
	 * @param description
	 * @param quantity
	 */
	public void registerSale(String description, int quantity) {
		if (items.containsKey(description)) {
			int temp = items.get(description);
			temp += quantity;
			items.put(description, temp);
		} else {
			items.put(description, quantity);
		}
	}

	/**
	 * Print all elements.
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