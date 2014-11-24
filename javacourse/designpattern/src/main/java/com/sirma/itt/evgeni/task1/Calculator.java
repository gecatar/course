package com.sirma.itt.evgeni.task1;

/**
 * Execute passed commands.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Calculator {

	/**
	 * Execute multiply command. Return result.
	 */
	public int multiply(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}

	/**
	 * Execute division command. Return result.
	 */
	public int division(int firstNumber, int secondNumber) {
		return firstNumber / secondNumber;
	}

	/**
	 * Execute sum command. Return result.
	 */
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * Execute deduct command. Return result.
	 */
	public int deduct(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

	/**
	 * Execute pow command. Return result.
	 */
	public int pow(int firstNumber, int secondNumber) {
		return (int) Math.pow(firstNumber, secondNumber);
	}

}
