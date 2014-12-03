package com.sirma.itt.evgeni.tas2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task2.Page;
import com.sirma.itt.evgeni.task2.PageBean;

/**
 * Test correct separating on arrays whit objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class PageBeanTest {

	PageBean pageBean;
	Object[] object;
	LinkedList<Page> pages;

	@Before
	public void setUp() throws Exception {
		pageBean = new PageBean();
		object = new Object[10];
		for (int i = 0; i < 10; i++) {
			object[i] = new Integer(i);
		}
	}

	/**
	 * Test correct returning on previous page.
	 */
	@Test
	public void previosTest() {
		pages = pageBean.getPages(object, 3);
		assertEquals(pages.get(0), pageBean.getNext());
		assertEquals(pages.get(1), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getNext());
		assertEquals(pages.get(3), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getPrevious());
		assertEquals(pages.get(1), pageBean.getPrevious());
		assertEquals(pages.get(0), pageBean.getPrevious());
		assertNull(pageBean.getPrevious());
	}

	/**
	 * Test correct returning on next page.
	 */
	@Test
	public void nextTest() {
		pages = pageBean.getPages(object, 3);
		assertEquals(pages.get(0), pageBean.getNext());
		assertEquals(pages.get(1), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getNext());
		assertEquals(pages.get(3), pageBean.getNext());
		assertNull(pageBean.getNext());
	}

	/**
	 * Check correct separating on pages.
	 */
	@Test
	public void getPagesTest() {
		pages = pageBean.getPages(object, 3);
		assertEquals(4, pages.size());
	}

}
