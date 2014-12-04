package com.sirma.itt.evgeni.reflection;

@Priority(priorityIndex = 33)
public class PrioritySecond extends TestClass {

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 52)
	public void testFunctionFirst() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit hightest priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 66)
	public void testFunctionSecond() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit medium priority");
	}

	/**
	 * Sample method for annotation example.
	 */
	@Priority(priorityIndex = 84)
	public void testFunctionThird() {
		System.out.println("Sample method for annotation example");
		System.out.println("methods whit lowest priority");
	}
}
