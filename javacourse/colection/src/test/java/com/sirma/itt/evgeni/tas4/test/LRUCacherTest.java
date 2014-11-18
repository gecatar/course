package com.sirma.itt.evgeni.tas4.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.task4.Cacher;

public class LRUCacherTest {

	@Test
	public void test() {
		Cacher cacher = new Cacher(2);
		Object[] obj = new Object[10];
		for (int i = 0; i < 10; i++) {
			obj[i] = new Integer(i);
		}
		cacher.addElement(0, obj[0]);
		cacher.addElement(1, obj[1]);
		assertTrue(cacher.toString().equals("1 0 "));
		cacher.addElement(2, obj[2]);
		assertTrue(cacher.toString().equals("2 1 "));
		cacher.addElement(2, obj[2]);
		assertTrue(cacher.toString().equals("2 1 "));
	}

}
