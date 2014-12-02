package com.sirma.itt.evgeni.task3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task3.PrivateReader;

/**
 * Test private read functionality on ReadPrivate class.
 * 
 * @author GecaTM
 * 
 */
public class PrivateReaderTest {

	TestClass testClass;
	PrivateReader privateReader;

	@Before
	public void setUp() throws Exception {
		testClass = new TestClass();
		privateReader = new PrivateReader();
	}

	/**
	 * Test invoking private methods.
	 */
	@Test
	public void invokePrivateMethodTest() {
		String expectedReport = "invoke:testPrivate - OK\n";
		String actualReport = privateReader.invokePrivateMethods(testClass);
		assertEquals(expectedReport, actualReport);
	}

	/**
	 * Test extracting field data functionality.
	 */
	@Test
	public void getPrivateFieldsTest() {
		String expectedReport = "Private fields:\ncount:9\n";
		String actualReport = privateReader.getPrivateFileds(testClass);
		assertEquals(expectedReport, actualReport);
	}

}
