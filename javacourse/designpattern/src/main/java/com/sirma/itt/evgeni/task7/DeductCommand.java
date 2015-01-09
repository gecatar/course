package com.sirma.itt.evgeni.task7;

/**
 * Execute deduct command.
 * 
 * @author root
 *
 */
public class DeductCommand implements Command {

	private Calculator calculator;

	public DeductCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Calculate two numbers.
	 */
	public int calculate(int firstNumber, int secondNumber) {
		return calculator.deduct(firstNumber, secondNumber);
	}

}