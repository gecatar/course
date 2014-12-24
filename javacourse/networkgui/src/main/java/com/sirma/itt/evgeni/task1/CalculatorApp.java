package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

/**
 * Calculate BigDecimal numbers.
 * 
 * @author GecaTM
 *
 */
public class CalculatorApp implements UIListener {

	private Calculator calculator = new Calculator();
	private CalculatorView calculatorView = new CalculatorView(this);
	private BigDecimal firstNumber;
	private boolean firstNumberDefined;
	private char nextOperation = ' ';

	/**
	 * Called when UI buttons are pressed.
	 */
	@Override
	public void calculatePresset(String number) {
		if (firstNumberDefined) {
			Operation temp = new Operation(firstNumber, new BigDecimal(number),
					nextOperation);
			calculatorView.displayResults(calculator.calculate(temp));
			firstNumberDefined = false;
		}
	}

	/**
	 * Called when UI buttons are pressed.
	 */
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

	/**
	 * Set first number.
	 * 
	 * @param firstNumber
	 */
	private void setFirstNumber(String firstNumber) {
		if (firstNumber != null) {
			this.firstNumber = new BigDecimal(firstNumber);
			firstNumberDefined = true;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("First number:").append(firstNumber).append("\n");
		stringBuilder.append("First number defined:")
				.append(firstNumberDefined).append("\n");
		stringBuilder.append("Next operation:").append(nextOperation);
		return stringBuilder.toString();
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
