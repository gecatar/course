package com.sirma.itt.evgeni.task7;

/**
 * Execute pow command.
 * 
 * @author root
 *
 */
public class PowCommand implements Command {

	private Calculator calculator;

	public PowCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Calculate two numbers.
	 */
	public int calculate(int firstNumber, int secondNumber) {
		return calculator.pow(firstNumber, secondNumber);

	}

}
