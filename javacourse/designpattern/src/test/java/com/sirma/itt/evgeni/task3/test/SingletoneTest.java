package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task3.Singletone;

public class SingletoneTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Check references returned from Class Singleton.
	 */
	@Test
	public void test() {
		Object object = Singletone.getReference();
		assertEquals(object, Singletone.getReference());
		assertEquals(object, Singletone.getReference());
	}

}
