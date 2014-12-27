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
	 */
	public LinkedList<Page> getPages() {
		return page;
	}

	/**
	 * Allow user to get pages one by one.
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
	 */
	public Page getPrevious() {
		if (containPage(currentIndex - 1)) {
			currentIndex--;
			return page.get(currentIndex);
		}
		throw new IndexOutOfBoundsException("There is no more pages!!!");
	}

	/**
	 * Return first page.
	 */
	public Page getFirstPage() {
		if (containPage(0)) {
			currentIndex = 0;
			return page.get(currentIndex);
		}
		return null;
	}

	/**
	 * Return last page.
	 */
	public Page getLastPage() {
		if (containPage(page.size() - 1)) {
			currentIndex = page.size() - 1;
			return page.get(currentIndex);
		}
		return null;
	}

	/**
	 * Return true if has next page.
	 */
	public boolean hasNext() {
		return containPage(currentIndex + 1);
	}

	/**
	 * Return true if has previous page.
	 */
	public boolean hasPrevious() {
		return containPage(currentIndex - 1);
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