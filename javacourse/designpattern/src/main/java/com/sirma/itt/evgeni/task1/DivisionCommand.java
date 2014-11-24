package com.sirma.itt.evgeni.task1;


public class DivisionCommand implements Command {

	Calculator calculator;

	public DivisionCommand(Calculator calculator) {
		this.calculator = calculator;
	}

	public int calculate(int firstNumber, int secondNumber) {
		return calculator.division(firstNumber, secondNumber);

	}

}