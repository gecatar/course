package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

public class CalculatorApp implements UIListener {

	private Calculator calculator = new Calculator();
	private CalculatorView calculatorView = new CalculatorView(this);
	private BigDecimal firstNumber;
	private boolean firstNumberDefined;
	private char nextOperation;

	@Override
	public void calculatePresset(String number) {
		if (firstNumberDefined) {
			Operation temp = new Operation(firstNumber, new BigDecimal(number),
					nextOperation);
			calculatorView.displayResults(calculator.calculate(temp));
			firstNumberDefined = false;
		}
	}

	@Override
	public void operationPresset(String number, char operation) {
		if (!firstNumberDefined) {
			setFirstNumber(number);
			nextOperation = operation;
		} else {
			Operation temp = new Operation(firstNumber, new BigDecimal(number),
					nextOperation);
			calculatorView.displayResults(calculator.calculate(temp));
			firstNumberDefined = false;
		}
	}

	private void setFirstNumber(String firstNumber) {
		if (firstNumber != null) {
			this.firstNumber = new BigDecimal(firstNumber);
			firstNumberDefined = true;
		}
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
