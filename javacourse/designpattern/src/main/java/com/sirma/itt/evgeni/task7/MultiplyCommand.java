package com.sirma.itt.evgeni.task7;

/**
 * Execute multiply command.
 * 
 * @author root
 *
 */
public class MultiplyCommand implements Command {

	Calculator calculator;

	public MultiplyCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.multiply(firstNumber, secondNumber);

	}

}