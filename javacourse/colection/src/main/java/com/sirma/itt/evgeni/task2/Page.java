package com.sirma.itt.evgeni.task2;

import java.util.List;

/**
 * Store list of objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Page {

	private String title;
	private List<?> elements;

	public Page(List<?> elements) {
		this.elements = elements;
	}

	/**
	 * Execute toString on every object stored on page.
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < elements.size(); i++) {
			stb.append("Element " + i + ":" + elements.get(i) + " ");
		}
		return stb.toString();
	}
}
