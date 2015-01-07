package com.sirma.itt.evgeni.task7;

/**
 * Execute sum command.
 * 
 * @author root
 *
 */
public class SumCommand implements Command {

	Calculator calculator;

	public SumCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.sum(firstNumber, secondNumber);

	}

}
