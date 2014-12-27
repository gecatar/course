package com.sirma.itt.evgeni.tas2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		object = new Object[10];
		for (int i = 0; i < 10; i++) {
			object[i] = new Integer(i);
		}

	}

	public void getFirstAndLastTest() {
		pageBean = new PageBean(object, 3);
		assertTrue(pageBean.getFirstPage() != null);
		assertTrue(pageBean.getLastPage() != null);
	}

	/**
	 * Test has next functionality.
	 */
	@Test
	public void hasNextTest() {
		pageBean = new PageBean(object, 3);
		assertTrue(pageBean.hasNext());
		pageBean.getNext();
		pageBean.getNext();
		pageBean.getNext();
		pageBean.getNext();
		assertFalse(pageBean.hasNext());
	}

	/**
	 * Test has previous functionality.
	 */
	@Test
	public void hasPreviousTest() {
		pageBean = new PageBean(object, 3);
		assertFalse(pageBean.hasPrevious());
		pageBean.getNext();
		pageBean.getNext();
		pageBean.getNext();
		assertTrue(pageBean.hasPrevious());
	}

	/**
	 * Test correct returning on previous page.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void previosTest() {
		pageBean = new PageBean(object, 3);
		pages = pageBean.getPages();
		assertEquals(pages.get(0), pageBean.getNext());
		assertEquals(pages.get(1), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getNext());
		assertEquals(pages.get(3), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getPrevious());
		assertEquals(pages.get(1), pageBean.getPrevious());
		assertEquals(pages.get(0), pageBean.getPrevious());
		assertEquals(pages.get(0), pageBean.getPrevious());
	}

	/**
	 * Test correct returning on next page.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void nextTest() {
		pageBean = new PageBean(object, 3);
		pages = pageBean.getPages();
		assertEquals(pages.get(0), pageBean.getNext());
		assertEquals(pages.get(1), pageBean.getNext());
		assertEquals(pages.get(2), pageBean.getNext());
		assertEquals(pages.get(3), pageBean.getNext());
		assertEquals(pages.get(3), pageBean.getNext());
	}

}
