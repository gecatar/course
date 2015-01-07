package com.sirma.itt.evgeni.task7;

/**
 * Execute division command.
 * 
 * @author root
 *
 */
public class DivisionCommand implements Command {

	Calculator calculator;

	public DivisionCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.division(firstNumber, secondNumber);

	}

}