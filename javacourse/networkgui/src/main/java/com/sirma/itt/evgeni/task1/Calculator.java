package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

	public BigDecimal calculate(Operation operation) {
		if (operation.operation == '*') {
			return operation.firstNumber.multiply(operation.secondNumber);
		}
		if (operation.operation == '/') {
			return operation.firstNumber.divide(operation.secondNumber, 9,
					RoundingMode.CEILING);
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
