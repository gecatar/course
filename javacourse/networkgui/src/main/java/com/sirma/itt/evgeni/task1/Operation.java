package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;

/**
 * Contain two numbers and operation.
 * 
 * @author GecaTM
 *
 */
public class Operation {

	public BigDecimal firstNumber;
	public BigDecimal secondNumber;
	public char operation;

	public Operation(BigDecimal firstNumber, BigDecimal secondNumber,
			char operation) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.operation = operation;
	}

	/**
	 * Print numbers and operation.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append("First number:").append(firstNumber);
		stringBuilder.append(" Second number:").append(secondNumber);
		stringBuilder.append(" Operation:").append(operation);
		return stringBuilder.toString();
	}

}
