package com.sirma.itt.evgeni.task6;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Store object for defined time. If objects are not used they are deleted from list.
 * @author Evgeni Stefanov
 *
 */
public class TimeOutTable {

	private Map<String, Object> table = new HashMap<String, Object>();
	private ArrayDeque<String> used = new ArrayDeque<String>();
	private ArrayDeque<String> unUsed = new ArrayDeque<String>();
	private Remover remover;
	
	public TimeOutTable(int removerInterval) {
		remover = new Remover(this, removerInterval);
		remover.start();
	}

	/**
	 * Release thread that call function for deleting unused item.
	 */
	public void releaseRemover() {

		if (table.size() > 0) {
			synchronized (this) {
				notifyAll();
			}
		}
	}

	/**
	 * Lock thread that call function for deleting objects.
	 */
	public void lockRemover() {
		while (table.size() == 0) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Delete unused objects.
	 */
	public void removeUnused() {
		for (String key : unUsed) {
			table.remove(key);
			unUsed.remove(key);
		}
		ArrayDeque<String> temp = unUsed;
		unUsed = used;
		used = temp;
	}

	/**
	 * Remove object from list.
	 * @param key that represent object from map.
	 */
	public void remove(String key) {
		if (unUsed.contains(key)) {
			unUsed.remove(key);
			table.remove(key);
		} else {
			if (used.contains(key)) {
				used.remove(key);
				table.remove(key);
			}
		}
	}

	/**
	 * Add object in map by specified key.
	 * @param key represent object in map.
	 * @param object that will be addet to map.
	 */
	public void put(String key, Object object) {
		table.put(key, object);
		used.add(key);
		releaseRemover();
	}

	/**
	 * Get object from map.
	 * @param key represent object in map
	 * @return object extracted from map.
	 */
	public Object get(String key) {
		if (unUsed.contains(key)) {
			unUsed.remove(key);
			used.add(key);
			return table.get(key);
		} else {
			if (used.contains(key)) {
				return table.get(key);
			}
		}
		return null;
	}
}