package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task1.ClassAnalyzer;

public class ClassAnalyzerTest {

	ClassAnalyzer analyzer = new ClassAnalyzer();
	TestClass temp = new TestClass();

	@Test
	public void listDeclaredMethodsTest() {

		String expectedInfo = "Declared methods:\nprivate testPrivate\npublic compare\n";
		assertEquals(expectedInfo, analyzer.listDeclaredMethods(temp));
	}

	@Test
	public void listDeclaredFieldTest() {
		String expectedInfo = "Declared fields:\nid:0\ncount:9\nindex:8\n";
		assertEquals(expectedInfo, analyzer.listDeclaredFields(temp));
	}
}
