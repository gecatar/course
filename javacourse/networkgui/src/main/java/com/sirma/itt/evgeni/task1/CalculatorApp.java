package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

public class CalculatorApp {

	private Calculator calculator = new Calculator();
	private CalculatorView calculatorView = new CalculatorView();
	private BigDecimal currentResult = new BigDecimal("0");
	private char operation;

	public void calculate(String number) {
		calculator.calculate(new Operation(currentResult,
				new BigDecimal(number), operation));
	}

	public void setOperation(char operation) {
		this.operation = operation;
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
