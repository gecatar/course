package com.sirma.itt.evgeni.task6;

import java.util.ArrayList;

/**
 * Store list whit sold out items.
 * 
 * @author GecaTM
 *
 */
public class SoldOutContainer implements Container {

	private ArrayList<String> soldOutItems = new ArrayList<String>();

	/**
	 * Update container.
	 */
	public void update(char operation, String description, int quantity,
			Observable obs) {
		if (operation == 'u') {
			addSoldOutItem(description);
		}
		if (operation == 'b') {
			removeSoldOutItem(description);
		}
	}

	/**
	 * Remove sold out item.
	 * 
	 * @param description
	 */
	private void removeSoldOutItem(String description) {
		if (soldOutItems.contains(description)) {
			soldOutItems.remove(description);
		}
	}

	/**
	 * Add sold out item.
	 * 
	 * @param description
	 */
	private void addSoldOutItem(String description) {
		if (!soldOutItems.contains(description)) {
			soldOutItems.add(description);
		}
	}

	/**
	 * Print all elements.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String item : soldOutItems) {
			stringBuilder.append("Description:").append(item).append("\n");
		}
		return stringBuilder.toString().trim();
	}
}
