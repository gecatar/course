package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

/**
 * Calculate BigDecimal numbers.
 * 
 * @author GecaTM
 *
 */
public class CalculatorApp implements UIListener {

	private static final int DIVISIONPRECISION = 4;
	private Calculator calculator = new Calculator(DIVISIONPRECISION);
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
			try {
				calculatorView.displayResults(calculator.calculate(temp)
						.toString());
			} catch (ArithmeticException e) {
				calculatorView.displayResults("Aritmetical eception!!!");
				calculatorView.trigerException();
			}
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
			try {
				firstNumber = calculator.calculate(temp);
				nextOperation = operation;
				calculatorView.displayResults(firstNumber.toString());
			} catch (ArithmeticException e) {
				firstNumberDefined = false;
				calculatorView.displayResults("Aritmetical eception!!!");
				calculatorView.trigerException();
			}

		}
	}

	/**
	 * When clear button is preset.
	 */
	@Override
	public void clearPreset() {
		firstNumberDefined = false;
	}

	/**
	 * Set first number.
	 */
	private void setFirstNumber(String firstNumber) {
		if (firstNumber != null) {
			this.firstNumber = new BigDecimal(firstNumber);
			firstNumberDefined = true;
		}
	}

	/**
	 * Print all elements.
	 */
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
	 */
	public static void main(String[] args) {
		new CalculatorApp();
	}
}
