package com.sirma.itt.evgeni.task6;

import java.util.ArrayList;

/**
 * Manage observers. Add observers to list and notify them when change occur.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Trader implements Observable {

	// list whit observers.
	private ArrayList<Container> containers = new ArrayList<Container>();

	/**
	 * Add observer to list.
	 */
	public void addObserver(Container container) {
		containers.add(container);
	}

	/**
	 * Create message and send it to all observers.
	 */
	public void buyItem(String description, int quantity) {
		notifyAll('b', description, quantity);
	}

	/**
	 * Create message and send it to all observers.
	 */
	public void sellItem(String description, int quantity) {
		notifyAll('s', description, quantity);
	}

	/**
	 * Send message to all observers.
	 */
	public void notifyAll(char operation, String description, int quantity) {
		for (Container container : containers) {
			container.update(operation, description, quantity, this);
		}
	}

	/**
	 * Call toString function on all observers and display result.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for (Container container : containers) {
			stb.append(container.toString());
		}
		return stb.toString();
	}
}
