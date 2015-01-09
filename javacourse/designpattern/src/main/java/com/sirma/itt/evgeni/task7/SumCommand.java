package com.sirma.itt.evgeni.task7;

/**
 * Execute sum command.
 * 
 * @author root
 *
 */
public class SumCommand implements Command {

	private Calculator calculator;

	public SumCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Calculate two numbers.
	 */
	public int calculate(int firstNumber, int secondNumber) {
		return calculator.sum(firstNumber, secondNumber);

	}

}
