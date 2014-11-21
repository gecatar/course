package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task1.ClassAnalyzer;

public class ClassAnalyzerTest {

	@Test
	public void ListDeclaredMethodsTest() {
		ClassAnalyzer analyzer = new ClassAnalyzer();
		TestClass temp = new TestClass();
		String expectedInfo = "Declared methods:\nprivate testPrivate\npublic compare\npublic getString\n";
		assertEquals(expectedInfo, analyzer.listDeclaredMethods(temp));
	}

}
