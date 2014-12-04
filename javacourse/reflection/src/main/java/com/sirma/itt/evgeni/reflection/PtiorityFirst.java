package com.sirma.itt.evgeni.reflection;

@Priority(priorityIndex = 9)
public class PtiorityFirst extends TestClass {

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 67)
	public void testFunctionFirst() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit hightest priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 81)
	public void testFunctionSecond() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit medium priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 99)
	public void testFunctionThird() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit lowest priority");
	}

}
