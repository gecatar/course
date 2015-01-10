package com.sirma.itt.evgeni.client.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.client.ClientConector;
import com.sirma.itt.evgeni.comunication.Conector;

public class ClientConectorTest {

	private Conector conector;

	@Before
	public void setUp() throws Exception {
		conector = new ClientConector(null);
	}

	@Test
	public void startConectionTest() {
		assertTrue(conector.startConection("", 123));
		assertFalse(conector.startConection("", 123));
		conector.stopConection();
		assertTrue(conector.startConection("", 123));
	}

	@Test
	public void stopConectionTest() {
		assertFalse(conector.stopConection());
		conector.startConection("", 123);
		assertTrue(conector.stopConection());
	}

}
