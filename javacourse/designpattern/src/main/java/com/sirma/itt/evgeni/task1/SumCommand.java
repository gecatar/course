package com.sirma.itt.evgeni.task1;

public class SumCommand implements Command {

	Calculator calculator;

	public SumCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.sum(firstNumber, secondNumber);

	}

}
