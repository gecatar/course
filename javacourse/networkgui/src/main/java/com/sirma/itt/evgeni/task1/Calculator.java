package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculate Big Decimal numbers.
 * 
 * @author GecaTM
 *
 */
public class Calculator {

	private int divisionPrecision;

	public Calculator(int divisionPrecision) {
		this.divisionPrecision = divisionPrecision;
	}

	public BigDecimal calculate(Operation operation) {
		if (operation.operation == '*') {
			return operation.firstNumber.multiply(operation.secondNumber);
		}
		if (operation.operation == '/') {
			return operation.firstNumber.divide(operation.secondNumber,
					divisionPrecision, RoundingMode.CEILING);
		}
		if (operation.operation == '+') {
			return operation.firstNumber.add(operation.secondNumber);
		}
		if (operation.operation == '-') {
			return operation.firstNumber.subtract(operation.secondNumber);
		}
		throw new IllegalArgumentException();

	}
}
