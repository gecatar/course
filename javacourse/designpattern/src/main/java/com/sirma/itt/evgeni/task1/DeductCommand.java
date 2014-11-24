package com.sirma.itt.evgeni.task1;

public class DeductCommand implements Command {

	Calculator calculator;

	public DeductCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.deduct(firstNumber, secondNumber);
	}

}