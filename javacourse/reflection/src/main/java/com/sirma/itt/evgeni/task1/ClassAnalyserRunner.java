package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.util.ReflectionUtil;

/**
 * Allow set primitive value on selected class. List all declared functions and
 * variables.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ClassAnalyserRunner {

	/**
	 * Set primitive values and list all methods and variables.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		TestClass temp = new TestClass();
		ReflectionUtil.setClass(temp);
		System.out.println("State after setup:");
		ReflectionUtil.analyse(temp);
	}

}