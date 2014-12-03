package com.sirma.itt.evgeni.task2;

import java.util.LinkedList;

/**
 * Create Pages that store objects. Print their content.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBean {

	private Page[] page;
	private int curent = -1;
	private Page currentPage;
	private LinkedList<Page> pgs;

	/**
	 * Create collection of pages.
	 * 
	 * @param obj
	 *            objects for adding to pages.
	 * @param pageSize
	 *            how much items to contain every page.
	 * @return collection whit pages.
	 */
	public Page[] getPages(Object[] obj, int pageSize) {

		curent = -1;
		int pages = obj.length / pageSize;
		if (obj.length % pageSize > 0) {
			pages++;
		}
		page = new Page[pages];
		for (int i = 0; i < pages; i++) {
			page[i] = new Page();
			for (int j = 0; j < pageSize; j++) {
				if (i * pageSize + j < obj.length) {
					page[i].addElement(obj[i * pageSize + j]);
				}
			}
		}
		return page;
	}

	public Page getNext() {
		if (currentPage == null) {
			return pgs.getFirst();
		} else {
			int index = pgs.indexOf(currentPage);
			index++;
			if (index < pgs.size()) {
				return pgs.get(index);
			} else {
				index--;
				return null;
			}
		}
	}

	public Page getPrevious() {
		if (currentPage == null) {
			return pgs.getLast();
		} else {
			int index = pgs.indexOf(currentPage);
			index--;
			if (index > 0) {
				return pgs.get(index);
			} else {
				index++;
				return null;
			}
		}
	}

	/**
	 * Allow user to get pages one by one.
	 * 
	 * @return pages starting from first page.
	 */
	public Page next() {
		Page temp;
		curent++;
		if (curent < page.length) {
			temp = page[curent];
		} else {
			curent--;
			System.out.println("No more pages left!!!!");
			temp = null;
		}
		return temp;
	}

	/**
	 * Get previous page. It must be called next before previous.
	 * 
	 * @return object page containing objects.
	 */
	public Page previos() {
		curent--;
		Page temp;
		if (curent >= 0) {
			temp = page[curent];
		} else {
			curent++;
			System.out.println("No more pages left!!!!");
			temp = null;
		}
		return temp;
	}
}