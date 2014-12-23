package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

public class CalculatorApp {

	private Calculator calculator = new Calculator();
	private CalculatorView calculatorView = new CalculatorView();
	private BigDecimal currentResult = new BigDecimal("0");

	public void calculate(String number, char operation) {
		calculator.calculate(new Operation(currentResult,
				new BigDecimal(number), operation));
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
