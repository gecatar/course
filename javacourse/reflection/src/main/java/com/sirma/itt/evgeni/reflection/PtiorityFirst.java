package com.sirma.itt.evgeni.reflection;

@Priority(priorityIndesx = 0)
public class PtiorityFirst extends TestClass {

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 67)
	public void testFunctionFirst() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit hightest priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 81)
	public void testFunctionSecond() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit medium priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 99)
	public void testFunctionThird() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit lowest priority");
	}

}
