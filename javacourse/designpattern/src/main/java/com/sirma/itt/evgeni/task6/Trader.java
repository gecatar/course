package com.sirma.itt.evgeni.task6;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Manage observers. Add observers to list and notify them when change occur.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Trader implements Observable {

	private static final Logger LOGGER = Logger.getLogger(Trader.class
			.getName());

	// list whit observers.
	private final ArrayList<Container> containers = new ArrayList<Container>();

	/**
	 * Add observer to list.
	 */
	public void addObserver(Container container) {
		containers.add(container);
		LOGGER.log(Level.INFO, "Observer added.");
	}

	/**
	 * Create message and send it to all observers.
	 */
	public void buyItem(String description, int quantity) {
		if (description != null) {
			notifyAll('b', description, quantity);
		} else {
			LOGGER.log(Level.ERROR, "Invalid data passed!!!");
		}
	}

	/**
	 * Create message and send it to all observers.
	 */
	public void sellItem(String description, int quantity) {
		if (description != null) {
			notifyAll('s', description, quantity);
		} else {
			LOGGER.log(Level.ERROR, "Invalid data passed!!!");
		}
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
			stb.append(container.toString()).append("\n");
		}
		return stb.toString().trim();
	}
}
