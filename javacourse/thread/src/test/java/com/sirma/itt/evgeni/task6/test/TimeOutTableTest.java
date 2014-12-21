package com.sirma.itt.evgeni.task6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.task6.TimeOutTable;

public class TimeOutTableTest {

	TimeOutTable table;

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
		table.removeUnused();
		assertEquals("test11", table.get("test1").toString());
	}

	/**
	 * Test remove object.
	 */
	@Test
	public void removeUnusedObjectTest() {
		table = new TimeOutTable(10000);
		table.put("test1", "test11");
		table.put("test2", "test22");
		table.put("test3", "test33");
		table.removeUnused();
		table.get("test2");
		table.removeUnused();
		assertEquals("key:test2 element:test22", table.toString());
	}

	/**
	 * Test removing on objects from table.
	 */
	public void removeObjectByKeyTest() {
		table = new TimeOutTable(10000);
		table.put("test1", "test11");
		table.remove("test1");
		assertEquals(table.get("test1"), null);
	}
}
