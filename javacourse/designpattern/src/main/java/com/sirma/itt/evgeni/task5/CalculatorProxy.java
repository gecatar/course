package com.sirma.itt.evgeni.task5;

/**
 * Proxy class that will use real calculator class.
 * In some cases users will not have privilege to use some functions.
 * @author Evgeni Stefanov
 *
 */
public class CalculatorProxy {

	private Calculator calculator;
	private String user;

	public CalculatorProxy(String user) {
		this.user = user;
	}

	public int pow(int firstNumber, int pow) {

		return calculator.pow(firstNumber, pow);
	}

	public int divisor(int firstNumber, int secondNumber) {
		if (user.equals("User")) {
			System.out.println("You do not have acces to this function!!!!");
			return 0;
		}
		return calculator.divisor(firstNumber, secondNumber);
	}

	public int sum(int firstNumber, int secondNumber) {
		return calculator.sum(firstNumber, secondNumber);
	}

	public int decrement(int firstNumber) {
		return calculator.decrement(firstNumber);
	}
}
