package com.sirma.itt.evgeni.task5;

/**
 * Real object that will be accessed via proxy class.
 * 
 * @author Evgeni Stefanov
 *
 */
public class Calculator {

	/**
	 * Excecute pow operation.
	 */
	public int pow(int firstNumber, int pow) {
		return (int) Math.pow(firstNumber, pow);
	}

	/**
	 * Divide two numbers.
	 */
	public int divisor(int firstNumber, int secondNumber) {
		return firstNumber / secondNumber;
	}

	/**
	 * Sum two numbers.
	 */
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * Decrement one number.
	 */
	public int decrement(int firstNumber) {
		firstNumber--;
		return firstNumber;
	}
}