package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.reflection.TestClass;

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

		ClassAnalyzer analyzer = new ClassAnalyzer();
		TestClass temp = new TestClass();
		System.out.println(analyzer.listDeclaredFields(temp));
		System.out.println("-----------------------------------");
		System.out.println(analyzer.listDeclaredMethods(temp));
	}

}