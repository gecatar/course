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
	 * Add element in Dequeue. Dequeue is used for accessing first and last
	 * element.
	 */
	public void addElement(int key, Object object) {
		if (count < capacity) {
			putInNotFullList(key, object);
		} else {
			putInFullList(key, object);
		}
	}

	/**
	 * Return object by specified key and put its key on first position.
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
	 */
	private boolean makeKeyFirst(int key) {
		if (lruCache.contains(key)) {
			lruCache.remove(key);
			lruCache.addFirst(key);
			return true;
		}
		return false;
	}

	/**
	 * Put elements when list is full.
	 */
	private void putInFullList(int key, Object object) {
		if (objectMap.containsKey(key)) {
			makeKeyFirst(key);
		} else {
			int lastKey = lruCache.getLast();
			objectMap.remove(lastKey);
			lruCache.remove(lastKey);
			objectMap.put(key, object);
			lruCache.addFirst(key);
		}

	}

	/**
	 * Put element when list is not full.
	 */
	private void putInNotFullList(int key, Object object) {
		if (objectMap.containsKey(key)) {
			makeKeyFirst(key);
		} else {
			count++;
			objectMap.put(key, object);
			lruCache.addFirst(key);
		}
	}

	/**
	 * Print all elements.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for (Object object : lruCache.toArray()) {
			stb.append(object).append(" ");
		}
		return stb.toString();
	}

}
