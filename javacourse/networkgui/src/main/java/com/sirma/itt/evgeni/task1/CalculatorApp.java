package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

public class CalculatorApp implements UIListener {

	private Calculator calculator = new Calculator();
	private CalculatorView calculatorView = new CalculatorView(this);
	private BigDecimal currentResult = new BigDecimal("10");
	private char operation;

	public void calculate(String number) {
		calculator.calculate(new Operation(currentResult,
				new BigDecimal(number), operation));
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	@Override
	public void calculatePresset(String number, char operation) {
		Operation temp = new Operation(currentResult, new BigDecimal(number),
				operation);
		calculatorView.displayResults(calculator.calculate(temp));

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
