package com.sirma.itt.evgeni.task2;

import java.util.LinkedList;

/**
 * Create Pages that store objects. Print their content.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBean {

	private LinkedList<Page> page;
	private Page currentPage;

	/**
	 * Create collection of pages.
	 * 
	 * @param obj
	 *            objects for adding to pages.
	 * @param pageSize
	 *            how much items to contain every page.
	 * @return collection whit pages.
	 */
	public LinkedList<Page> getPages(Object[] object, int pageSize) {
		page = new LinkedList<Page>();
		if (object == null) {
			return page;
		}
		int pages = object.length / pageSize;
		if (object.length % pageSize > 0) {
			pages++;
		}
		for (int i = 0; i < pages; i++) {
			Page temp = new Page();
			for (int j = 0; j < pageSize; j++) {
				if (i * pageSize + j < object.length) {
					temp.addElement(object[i * pageSize + j]);
				}
			}
			page.add(temp);
		}
		return page;
	}

	/**
	 * Allow user to get pages one by one.
	 * 
	 * @return pages starting from first page.
	 */
	public Page getNext() {
		if (currentPage == null) {
			currentPage = page.getFirst();
			return currentPage;
		} else {
			int index = page.indexOf(currentPage);
			index++;
			if (index < page.size()) {
				currentPage = page.get(index);
				return currentPage;
			} else {
				index--;
				return null;
			}
		}
	}

	/**
	 * Return previous page.
	 * 
	 * @return
	 */
	public Page getPrevious() {
		if (currentPage == null) {
			currentPage = page.getLast();
			return currentPage;
		} else {
			int index = page.indexOf(currentPage);
			index--;
			if (index < page.size() && index >= 0) {
				currentPage = page.get(index);
				return currentPage;
			} else {
				index++;
				return null;
			}
		}
	}
}