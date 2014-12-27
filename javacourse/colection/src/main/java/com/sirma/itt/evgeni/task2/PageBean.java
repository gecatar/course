package com.sirma.itt.evgeni.task2;

import java.util.LinkedList;

/**
 * Create Pages that store objects. Print their content.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBean {

	private final LinkedList<Page> page;
	private int currentIndex;

	/**
	 * Create Page Bean.
	 * 
	 * @param object
	 * @param pageSize
	 */
	public PageBean(Object[] object, int pageSize) {
		currentIndex = -1;
		page = new LinkedList<Page>();
		if (object != null) {
			int pages = getNumberOfPages(object.length, pageSize);
			for (int i = 0; i < pages; i++) {
				Page temp = new Page();
				for (int j = 0; j < pageSize; j++) {
					if (i * pageSize + j < object.length) {
						temp.addElement(object[i * pageSize + j]);
					}
				}
				page.add(temp);
			}
		}
	}

	/**
	 * Create collection of pages.
	 * 
	 * @param obj
	 *            objects for adding to pages.
	 * @param pageSize
	 *            how much items to contain every page.
	 * @return collection whit pages.
	 */
	public LinkedList<Page> getPages() {
		return page;
	}

	public boolean hasNext() {
		return containPage(currentIndex + 1);
	}

	public boolean hasPrevious() {
		return containPage(currentIndex - 1);
	}

	/**
	 * Allow user to get pages one by one.
	 * 
	 * @return pages starting from first page.
	 */
	public Page getNext() {
		if (containPage(currentIndex + 1)) {
			currentIndex++;
			return page.get(currentIndex);
		}
		throw new IndexOutOfBoundsException("There is no more pages!!!");
	}

	/**
	 * Return previous page.
	 * 
	 * @return
	 */
	public Page getPrevious() {
		if (containPage(currentIndex - 1)) {
			currentIndex--;
			return page.get(currentIndex);
		}
		throw new IndexOutOfBoundsException("There is no more pages!!!");
	}

	private int getNumberOfPages(int elementCount, int pageSize) {
		int pages = elementCount / pageSize;
		if (elementCount % pageSize > 0) {
			pages++;
		}
		return pages;
	}

	private boolean containPage(int index) {
		if (index < page.size() && index >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Page temp : page) {
			stringBuilder.append(temp).append("\n");
		}
		return stringBuilder.toString().trim();
	}
}