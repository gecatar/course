package com.sirma.itt.evgeni.reflection;

@Priority(priorityIndesx = 33)
public class PrioritySecond extends TestClass{

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 52)
	public void testFunctionFirst() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit hightest priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 66)
	public void testFunctionSecond() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit medium priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndesx = 84)
	public void testFunctionThird() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit lowest priority");
	}
}

