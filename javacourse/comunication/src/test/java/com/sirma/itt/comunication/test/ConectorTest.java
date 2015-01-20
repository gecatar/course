package com.sirma.itt.comunication.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.comunication.Conector;

public class ConectorTest {

	private Conector conector;

	@Before
	public void setUp() throws Exception {
		conector = new StartStopTest(null);
	}

	/**
	 * Check correct starting on connection.
	 */
	@Test
	public void startConectionTest() {
		assertTrue(conector.startConection("", 0));
		assertFalse(conector.startConection("", 0));
		conector.stopConection();
		assertTrue(conector.startConection("", 0));
	}

	/**
	 * Check correct stopping on connection.
	 */
	public void stopConectionTest() {
		assertFalse(conector.stopConection());
		conector.startConection("", 9);
		assertTrue(conector.stopConection());
		assertFalse(conector.stopConection());
	}

}
