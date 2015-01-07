package com.sirma.itt.evgeni.task7;

/**
 * Execute pow command.
 * 
 * @author root
 *
 */
public class PowCommand implements Command {

	Calculator calculator;

	public PowCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.pow(firstNumber, secondNumber);

	}

}
