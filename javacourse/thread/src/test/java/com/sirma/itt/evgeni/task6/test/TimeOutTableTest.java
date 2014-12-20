package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task6.TimeOutTable;

public class TimeOutTableTest {

	TimeOutTable table;

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test put object.
	 */
	@Test
	public void putObjectTest() {
		table = new TimeOutTable(10000);
		table.put("test1", "test11");
		assertEquals("key:test1 element:test11", table.toString());
	}

	/**
	 * Test get object.
	 */
	@Test
	public void getObjectTest() {
		table = new TimeOutTable(10000);
		table.put("test1", "test11");
		assertEquals("test11", table.get("test1").toString());
	}

	/**
	 * Test remove object.
	 */
	@Test
	public void removeObjectTest() {

	}

	/**
	 * Test remove unused objects.
	 */
	@Test
	public void removeUnusedTest() {

	}

}
