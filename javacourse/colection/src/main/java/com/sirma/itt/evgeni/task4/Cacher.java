package com.sirma.itt.evgeni.task4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Apply LRU cache algorithm.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Cacher {

	private final ArrayDeque<Integer> lruCache = new ArrayDeque<Integer>();
	private final Map<Integer, Object> objectMap = new HashMap<Integer, Object>();
	private final int capacity;
	private int count = 0;

	public Cacher(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Add element in Deque. Deque is used for accessing first and last element.
	 * 
	 * @param key
	 *            represent object in map.
	 * @param obj
	 *            that will be added in map whit specified key.
	 */
	public void addElement(int key, Object obj) {
		if (count < capacity) {
			putInNotFullList(key, obj);
		} else {
			putInFullList(key, obj);
		}
	}

	/**
	 * Print all elements.
	 * 
	 * @return elements represented as string.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		Object[] temp = lruCache.toArray();
		for (Object object : temp) {
			stb.append(object).append(" ");
		}
		return stb.toString();
	}

	/**
	 * Return object by specified key and put its key on first position.
	 * 
	 * @param key
	 * @return
	 */
	public Object getObject(int key) {
		if (objectMap.containsKey(key)) {
			makeKeyFirst(key);
			return objectMap.get(key);
		}
		return null;
	}

	/**
	 * Make passed key on first position in list.
	 * 
	 * @param key
	 * @return
	 */
	public boolean makeKeyFirst(int key) {
		if (lruCache.contains(key)) {
			lruCache.remove(key);
			lruCache.addFirst(key);
			return true;
		}
		return false;
	}

	/**
	 * Put elements when list is full.
	 * 
	 * @param key
	 *            represent key for object.
	 * @param obj
	 *            will be added in map.
	 */
	void putInFullList(int key, Object obj) {
		if (objectMap.containsKey(key)) {
			lruCache.remove(key);
			lruCache.addFirst(key);
		} else {
			int lastKey = lruCache.getLast();
			objectMap.remove(lastKey);
			lruCache.remove(lastKey);
			objectMap.put(key, obj);
			lruCache.addFirst(key);

		}

	}

	/**
	 * Put element when list is not full.
	 * 
	 * @param key
	 * @param obj
	 */
	void putInNotFullList(int key, Object obj) {
		if (objectMap.containsKey(key)) {
			lruCache.remove(key);
			lruCache.addFirst(key);
		} else {
			count++;
			objectMap.put(key, obj);
			lruCache.addFirst(key);
		}
	}

}
