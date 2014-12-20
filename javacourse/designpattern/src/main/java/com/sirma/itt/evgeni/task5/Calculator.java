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
	 * 
	 * @param firstNumber
	 * @param pow
	 * @return
	 */
	public int pow(int firstNumber, int pow) {
		return (int) Math.pow(firstNumber, pow);
	}

	/**
	 * Divide two numbers.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public int divisor(int firstNumber, int secondNumber) {
		return firstNumber / secondNumber;
	}

	/**
	 * Sum two numbers.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * Decrement one number.
	 * 
	 * @param firstNumber
	 * @return
	 */
	public int decrement(int firstNumber) {
		firstNumber--;
		return firstNumber;
	}
}