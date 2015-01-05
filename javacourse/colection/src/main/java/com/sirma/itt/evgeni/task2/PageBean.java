package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

/**
 * Create Pages that store objects. Print their content.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBean {

	private final ArrayList<Page> page;
	private int currentIndex;

	/**
	 * Create Page Bean.
	 */
	public PageBean(ArrayList<?> object, int pageSize) {
		currentIndex = -1;
		page = new ArrayList<Page>();
		if (object != null) {
			int pages = getNumberOfPages(object.size(), pageSize);
			for (int i = 0; i < pages; i++) {
				int fromIndex = i * pageSize;
				int toIndex = i * pageSize + pageSize;
				if (toIndex > object.size()) {
					toIndex = object.size();
				}
				page.add(new Page(object.subList(fromIndex, toIndex)));
			}
		}
	}

	/**
	 * Create collection of pages.
	 */
	public ArrayList<Page> getPages() {
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

	/**
	 * Return number of pages.
	 */
	private int getNumberOfPages(int elementCount, int pageSize) {
		int pages = elementCount / pageSize;
		if (elementCount % pageSize > 0) {
			pages++;
		}
		return pages;
	}

	/**
	 * Return true if contain page.
	 */
	private boolean containPage(int index) {
		return (index < page.size() && index >= 0);
	}

	/**
	 * Print all elements.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Page temp : page) {
			stringBuilder.append(temp).append("\n");
		}
		return stringBuilder.toString().trim();
	}
}