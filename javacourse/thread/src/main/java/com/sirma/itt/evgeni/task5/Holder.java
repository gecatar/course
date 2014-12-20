package com.sirma.itt.evgeni.task5;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Save strings in massive. Execute two operations. Add element and remove
 * element. Elements are random strings whit user defined length.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Holder {

	private static final Logger LOGGER = Logger.getLogger(Holder.class
			.getName());

	public Holder(int count) {
		this.count = count;
	}

	private ArrayList<String> strings = new ArrayList<String>();
	private int count;

	/**
	 * Add element in massive. Generate random string whit given length. If
	 * massive is full throw index out of boundary exception. Print how many
	 * positions left.
	 */
	public synchronized void addElement(String string) {
		if (strings.size() < count) {
			strings.add(string);
			LOGGER.log(Level.INFO, "New element added.");
			notifyAll();
		} else {
			LOGGER.log(Level.INFO, "List is full.");
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupted", e);
			}
			addElement(string);
		}
	}

	/**
	 * Remove element from massive. If massive is empty throw index out of
	 * boundary exception. Print how much free space left.
	 */
	public synchronized void remove() {
		if (strings.size() > 0) {
			strings.remove(strings.size() - 1);
			LOGGER.log(Level.INFO, "Last element from list removed.");
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.log(Level.SEVERE, "Thread interupted", e);
			}
			remove();
		}

	}

	/**
	 * Print all elements on holder.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String string : strings) {
			stringBuilder.append("element:").append(string).append("\n");
		}
		return stringBuilder.toString().trim();
	}
}