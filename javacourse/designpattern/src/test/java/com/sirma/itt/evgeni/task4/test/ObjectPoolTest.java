package com.sirma.itt.evgeni.task4.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.evgeni.task4.ObjectPool;

public class ObjectPoolTest {

	ObjectPool pool;

	/**
	 * Check acquire.
	 */
	@Test
	public void aquireTest() {
		ObjectPool pool = new ObjectPool(2);
		Object[] testClass = new Object[4];
		testClass[0] = pool.aquire();
		assertNotNull(testClass[0]);
		testClass[1] = pool.aquire();
		assertNotNull(testClass[1]);
		testClass[0] = pool.aquire();
		assertNull(testClass[0]);
	}

	/**
	 * Check release.
	 */
	@Test
	public void releaseTest() {
		ObjectPool pool = new ObjectPool(2);
		Object[] testClass = new Object[4];
		testClass[0] = pool.aquire();
		pool.release(testClass[0]);
		assertTrue(pool.release(testClass[0]));
	}

}
