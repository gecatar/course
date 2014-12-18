package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

/**
 * Store list of objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Page {

	String title;
	ArrayList<Object> element = new ArrayList<Object>();

	/**
	 * Add element to page.
	 * 
	 * @param obj
	 */
	public void addElement(Object obj) {
		element.add(obj);
	}

	/**
	 * Execute toString on every object stored on page.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < element.size(); i++) {
			stb.append("Element " + i + ":" + element.get(i) + " ");
		}
		return stb.toString();
	}
}
