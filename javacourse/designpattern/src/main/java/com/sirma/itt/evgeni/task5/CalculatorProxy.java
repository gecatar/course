package com.sirma.itt.evgeni.task5;

/**
 * Proxy class that will use real calculator class. In some cases users will not
 * have privilege to use some functions.
 * 
 * @author Evgeni Stefanov
 *
 */
public class CalculatorProxy {

	private Calculator calculator;
	private String user;

	public CalculatorProxy(String user) {
		this.user = user;
		calculator = new Calculator();
	}

	/**
	 * Call real method.
	 * 
	 * @param firstNumber
	 * @param pow
	 * @return
	 */
	public int pow(int firstNumber, int pow) {
		return calculator.pow(firstNumber, pow);
	}

	/**
	 * Call real method.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public int divisor(int firstNumber, int secondNumber) {
		if (user.equals("User")) {
			throw new IllegalAccessError("User acces error.");
		}
		return calculator.divisor(firstNumber, secondNumber);
	}

	/**
	 * Call real method.
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
	public int sum(int firstNumber, int secondNumber) {
		return calculator.sum(firstNumber, secondNumber);
	}

	/**
	 * Call real method.
	 * 
	 * @param firstNumber
	 * @return
	 */
	public int decrement(int firstNumber) {
		return calculator.decrement(firstNumber);
	}
}
