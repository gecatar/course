package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task1.ClassAnalyzer;

/**
 * Check correct extracting on data whit reflection.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClassAnalyzerTest {

	ClassAnalyzer analyzer = new ClassAnalyzer();
	TestClass temp = new TestClass();

	/**
	 * Test for extracting Declared Methods.
	 */
	@Test
	public void listDeclaredMethodsTest() {

		String expectedInfo = "Declared methods:\npublic compare\nprivate testPrivate";
		assertEquals(expectedInfo, analyzer.listDeclaredMethods(temp));
	}

	/**
	 * Check reading Declared Fields.
	 */
	@Test
	public void listDeclaredFieldTest() {
		String expectedInfo = "Declared fields:\nid:0\ncount:9\nindex:8";
		assertEquals(expectedInfo, analyzer.listDeclaredFields(temp));
	}
}
