package com.sirma.itt.evgeni.task3;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.util.ReflectionUtil;

/**
 * Execute Private Reader Class that read private content from selected class.
 * @author Evgeni Stefanov
 *
 */
public class PrivateReaderRunner {

	/**
	 * Read private fields and execute private methods.
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateReader privateReader = new PrivateReader();
		TestClass testClass = new TestClass();
		System.out.println(privateReader.getPrivateFileds(testClass));
		System.out.println(privateReader.invokePrivateMethods(testClass));
	}

}