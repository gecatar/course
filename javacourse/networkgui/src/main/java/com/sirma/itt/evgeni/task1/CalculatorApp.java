package com.sirma.itt.evgeni.task1;

public class CalculatorApp {

	Calculator calculator = new Calculator();
	CalculatorView calculatorView = new CalculatorView();

	public void calculateOperation(Operation operation) {
		calculator.calculate(operation);
	}

	/**
	 * Calculator runner.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new CalculatorApp();
	}
}
