package com.sirma.itt.evgeni.tas4.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task4.Cacher;

/**
 * Check cacher functionality.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class LRUCacherTest {

	Cacher cacher;
	Object[] object;

	@Before
	public void setUp() throws Exception {

		object = new Object[10];

	}

	/**
	 * Test make key first function.
	 */
	@Test
	public void makeFirstKeyTest() {
		cacher = new Cacher(2);
		cacher.addElement(0, object[0]);
		cacher.addElement(1, object[1]);
		cacher.getObject(0);
		assertEquals("0 1 ", cacher.toString());
	}

	/**
	 * Test get object function.
	 */
	@Test
	public void getObjecttest() {
		cacher = new Cacher(2);
		cacher.addElement(0, object[0]);
		cacher.addElement(1, object[1]);
		cacher.getObject(0);
		assertEquals(cacher.getObject(0), object[0]);
	}

	/**
	 * Add element in not full list.
	 */
	@Test
	public void putInNotFullListTest() {
		cacher = new Cacher(2);
		cacher.addElement(0, object[0]);
		String expectedCache = "0 ";
		String actualCache = cacher.toString();
		assertEquals(expectedCache, actualCache);
		cacher.addElement(1, object[1]);
		expectedCache = "1 0 ";
		actualCache = cacher.toString();
		assertEquals(expectedCache, actualCache);
	}

	/**
	 * Check behavior when adding elements in full list.
	 */
	@Test
	public void putInFullListTest() {
		cacher = new Cacher(2);
		cacher.addElement(0, object[0]);
		String expectedCache = "0 ";
		String actualCache = cacher.toString();
		assertEquals(expectedCache, actualCache);
		cacher.addElement(1, object[1]);
		expectedCache = "1 0 ";
		actualCache = cacher.toString();
		assertEquals(expectedCache, actualCache);
		cacher.addElement(2, object[2]);
		expectedCache = "2 1 ";
		actualCache = cacher.toString();
		assertEquals(expectedCache, actualCache);

	}

}
