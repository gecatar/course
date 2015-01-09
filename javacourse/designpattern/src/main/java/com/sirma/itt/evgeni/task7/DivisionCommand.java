package com.sirma.itt.evgeni.task7;

/**
 * Execute division command.
 * 
 * @author root
 *
 */
public class DivisionCommand implements Command {

	private Calculator calculator;

	public DivisionCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Calculate two numbers.
	 */
	public int calculate(int firstNumber, int secondNumber) {
		return calculator.division(firstNumber, secondNumber);

	}

}