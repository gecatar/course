package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task2.ClassCreator;

/**
 * Test reflection functionality on ClassCreator class.
 * 
 * @author GecaTM
 * 
 */
public class ClassCreatorTest {

	ClassCreator classCreator;
	TestClass testClass;

	@Before
	public void setUp() throws Exception {
		classCreator = new ClassCreator();
		testClass = new TestClass();
	}

	/**
	 * Check create from name function.
	 */
	@Test
	public void createFromNameTest() {
		String name = "com.sirma.itt.evgeni.reflection.TestClass";
		assertEquals(TestClass.class, classCreator.createFromName(name)
				.getClass());
	}

	/**
	 * Check get parent function.
	 */
	@Test
	public void getParrentTest() {
		String expectedParrent = "Super class:class java.lang.Object";
		String actualParrent = classCreator.getParrent(testClass);
		assertEquals(expectedParrent, actualParrent);
	}

	/**
	 * Check list interfaces function.
	 */
	@Test
	public void listInterfacesTest() {
		String expectedInterfaces = "Intefaces:\njava.util.Comparator";
		String actualInterfaces = classCreator.listInterfaces(testClass);
		assertEquals(expectedInterfaces, actualInterfaces);
	}

}
