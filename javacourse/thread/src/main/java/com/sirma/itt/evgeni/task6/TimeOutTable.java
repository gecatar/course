package com.sirma.itt.evgeni.task6;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Store object for defined time. If objects are not used they are deleted from
 * list.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TimeOutTable {

	private static final Logger LOGGER = Logger.getLogger(TimeOutTable.class
			.getName());
	private final Map<String, Object> table = new HashMap<String, Object>();
	private ArrayDeque<String> used = new ArrayDeque<String>();
	private ArrayDeque<String> unUsed = new ArrayDeque<String>();
	private final Remover remover;

	public TimeOutTable(int removerInterval) {
		remover = new Remover(this, removerInterval);
		remover.start();
	}

	/**
	 * Release thread that call function for deleting unused item.
	 */
	private void releaseRemover() {
		if (table.size() > 0) {
			synchronized (this) {
				notifyAll();
			}
		}
	}

	/**
	 * Lock thread that call function for deleting objects.
	 */
	private void lockRemover() {
		while (table.size() == 0) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					LOGGER.log(Level.ERROR, "Thread interupted", e);
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
			LOGGER.log(Level.DEBUG, "Removing object" + key);
		}
		ArrayDeque<String> temp = unUsed;
		unUsed = used;
		used = temp;
	}

	/**
	 * Remove object from list.
	 * 
	 * @param key
	 *            that represent object from map.
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
	 * 
	 * @param key
	 *            represent object in map.
	 * @param object
	 *            that will be addet to map.
	 */
	public void put(String key, Object object) {
		table.put(key, object);
		used.add(key);
		releaseRemover();
	}

	/**
	 * Get object from map.
	 * 
	 * @param key
	 *            represent object in map
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

	/**
	 * Print all elements in table.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Entry<String, Object> entry : table.entrySet()) {
			stringBuilder.append("key:" + entry.getKey()).append(" element:")
					.append(entry.getValue()).append("\n");
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Call function for removing unused objects in last session.
	 * 
	 * @author Evgeni Stefanov
	 * 
	 */
	public class Remover extends Thread {

		private final TimeOutTable table;
		private final int interval;
		private boolean stop;

		/**
		 * Allow thread to be stooped safely.
		 * 
		 * @param stop
		 */
		public void setStop(boolean stop) {
			this.stop = stop;
		}

		public Remover(TimeOutTable table, int interval) {
			this.table = table;
			this.interval = interval;
		}

		/**
		 * Regular call function that delete unused objects.
		 */
		@Override
		public void run() {

			while (!stop) {
				try {
					table.lockRemover();
					sleep(interval);
					table.removeUnused();
				} catch (InterruptedException e) {
					LOGGER.log(Level.ERROR, "Thread interupted", e);
				}
			}
		}
	}
}