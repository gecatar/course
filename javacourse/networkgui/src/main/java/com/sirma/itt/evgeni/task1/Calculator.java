package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Calculator {

	public BigDecimal calculateOperations(ArrayList<Operation> operations) {
		BigDecimal operationResult = null;
		// Calculate divide and multiply first.
		for (int i = 0; i < operations.size();) {
			if (operations.get(i).operation == '/'
					|| operations.get(i).operation == '*') {
				operationResult = calculate(operations.get(i));
				if (i - 1 >= 0) {
					operations.get(i - 1).secondNumber = operationResult;
				}
				operations.remove(i);
				if (i < operations.size()) {
					operations.get(i).firstNumber = operationResult;
				}
			} else {
				i++;
			}
		}
		// Calculate subtract and adding.
		for (int i = 0; i < operations.size();) {
			if (operations.get(i).operation == '+'
					|| operations.get(i).operation == '-') {
				operationResult = calculate(operations.get(i));
				if (i - 1 >= 0) {
					operations.get(i - 1).secondNumber = operationResult;
				}
				operations.remove(i);
				if (i < operations.size()) {
					operations.get(i).firstNumber = operationResult;
				}
			} else {
				i++;
			}
		}
		if (operations.size() > 0) {
			throw new IllegalArgumentException();
		}
		return operationResult;
	}

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

	public char getOperation(String string, int index)
			throws IllegalArgumentException {
		if (string.length() <= index) {
			throw new IllegalArgumentException();
		}
		return string.charAt(index);
	}

	/**
	 * Extract number from passed string. Extracting start from Index.
	 * 
	 * @param string
	 * @param index
	 *            start extracting from this index.
	 * @return number as string.
	 * @throws IllegalArgumentException
	 */
	public String getNumber(String string, int index)
			throws IllegalArgumentException {

		StringBuilder stringBuilder = new StringBuilder();
		boolean dotIsFindet = false;
		for (; index < string.length(); index++) {
			char temp = string.charAt(index);
			if (Character.isDigit(temp) || temp == '.') {
				if (temp == '.') {
					if (!dotIsFindet) {
						dotIsFindet = true;
						stringBuilder.append(temp);
					} else {
						throw new IllegalArgumentException();
					}
				} else {
					stringBuilder.append(temp);
				}
			} else {
				if (stringBuilder.length() > 0) {
					return stringBuilder.toString();
				} else {
					throw new IllegalArgumentException();
				}
			}
		}
		if (stringBuilder.length() > 0) {
			return stringBuilder.toString();
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String calculateString(String string) {
		return calculateOperations(extractOperations(string)).toString();
	}

	/**
	 * Return list whit all operation extracted from string.
	 * 
	 * @param string
	 * @param index
	 * @return
	 */
	public ArrayList<Operation> extractOperations(String string) {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		String tempNumber = new String();
		boolean firstNumberExtracted = false;
		try {
			for (int index = 0; index < string.length();) {
				String firstNumber;
				if (!firstNumberExtracted) {
					firstNumber = getNumber(string, index);
					index += firstNumber.length();
				} else {
					firstNumber = tempNumber;
				}
				char operation = getOperation(string, index);
				index++;
				String secondNumber = getNumber(string, index);
				tempNumber = secondNumber;
				index += secondNumber.length();
				firstNumberExtracted = true;
				operations.add(new Operation(new BigDecimal(firstNumber),
						new BigDecimal(secondNumber), operation));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return operations;
	}
}
