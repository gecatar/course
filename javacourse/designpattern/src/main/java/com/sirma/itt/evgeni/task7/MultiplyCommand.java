package com.sirma.itt.evgeni.task7;

/**
 * Execute multiply command.
 * 
 * @author root
 *
 */
public class MultiplyCommand implements Command {

	private Calculator calculator;

	public MultiplyCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Calculate two numbers.
	 */
	public int calculate(int firstNumber, int secondNumber) {
		return calculator.multiply(firstNumber, secondNumber);

	}

}