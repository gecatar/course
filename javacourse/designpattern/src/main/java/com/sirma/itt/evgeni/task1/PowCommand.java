package com.sirma.itt.evgeni.task1;

public class PowCommand implements Command {

	Calculator calculator;

	public PowCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.pow(firstNumber, secondNumber);

	}

}
