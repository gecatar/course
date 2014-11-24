package com.sirma.itt.evgeni.tas2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task2.Page;
import com.sirma.itt.evgeni.task2.PageBean;

/**
 * Test correct separating on arrays whit objects.
 * @author Evgeni Stefanov
 *
 */
public class PageBeanTest {
	
	PageBean pageBean;
	Object[] object;
	Page[] pages;

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
	public void previosTest(){
		pages = pageBean.getPages(object, 3);
		assertNull(pageBean.previos());
		assertEquals(pages[0], pageBean.next());
		assertEquals(pages[1], pageBean.next());
		assertEquals(pages[2], pageBean.next());
		assertEquals(pages[3], pageBean.next());
		assertEquals(pages[2], pageBean.previos());
		assertEquals(pages[1], pageBean.previos());
		assertEquals(pages[0], pageBean.previos());
		assertNull(pageBean.previos());
	}
	
	/**
	 * Test correct returning on next page.
	 */
	@Test
	public void nextTest(){
		pages = pageBean.getPages(object, 3);
		assertEquals(pages[0], pageBean.next());
		assertEquals(pages[1], pageBean.next());
		assertEquals(pages[2], pageBean.next());
		assertEquals(pages[3], pageBean.next());
		assertNull(pageBean.next());
	}

	/**
	 * Check correct separating on pages.
	 */
	@Test
	public void getPagesTest() {
		pages = pageBean.getPages(object, 3);
		assertEquals(4, pages.length);
	}

}
