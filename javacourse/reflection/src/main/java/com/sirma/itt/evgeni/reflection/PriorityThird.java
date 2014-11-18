package com.sirma.itt.evgeni.reflection;

@Priority(priorityIndesx = 17)
public class PriorityThird extends TestClass{

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 57)
	public void testFunctionFirst() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit hightest priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 71)
	public void testFunctionSecond() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit medium priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 89)
	public void testFunctionThird() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit lowest priority");
	}
}

