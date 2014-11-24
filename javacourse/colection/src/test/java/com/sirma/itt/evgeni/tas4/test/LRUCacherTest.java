package com.sirma.itt.evgeni.tas4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task4.Cacher;

public class LRUCacherTest {

	Cacher cacher;
	Object[] object;
	
	@Before
	public void setUp() throws Exception {
		
		object = new Object[10];
		
	}
	
	/**
	 * Add element in not full list.
	 */
	@Test
	public void putInNotFullListTest(){
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
