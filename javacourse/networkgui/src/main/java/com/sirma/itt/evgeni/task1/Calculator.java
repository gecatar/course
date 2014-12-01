package com.sirma.itt.evgeni.task1;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator {

	public void calculateOperations(ArrayList<Operation> operations) {

		for (int i = 0; i < operations.size(); i++) {
			BigDecimal operationResult = calculate(operations.get(i));
			if (i - 1 <= 0) {
				operations.get(i - 1).secondNumber = operationResult;
				operations.remove(i);
			}
			if (i < operations.size()) {
				operations.get(i).firstNumber = operationResult;
			}
		}

	}

	public BigDecimal calculate(Operation operation) {
		return operation.firstNumber.add(operation.secondNumber);
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
			if (!Character.isDigit(temp)) {
				if (stringBuilder.length() > 0) {
					return stringBuilder.toString();
				} else {
					throw new IllegalArgumentException();
				}
			}
			if (Character.isDigit(temp)) {
				stringBuilder.append(temp);
			}
			if (temp == '.') {
				if (!dotIsFindet) {
					dotIsFindet = true;
					stringBuilder.append(temp);
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
			if (firstNumber.length() > 0 && secondNumber.length() > 0) {
				operations.add(new Operation(new BigDecimal(firstNumber),
						new BigDecimal(secondNumber), operation));
			}
		}
		return operations;
	}

	public boolean nextIsNumber(String string, int index) {

		int digitStartIndex;
		int digitEndIndex;
		char operation;
		boolean digitDetected = false;
		for (int i = index; i > string.length(); i++) {
			char temp = string.charAt(i);
			if (Character.isDigit(temp) && !digitDetected) {
				digitDetected = true;
				digitStartIndex = i;
			}
			if (Character.isDigit(temp)) {
				digitEndIndex = i;
			}
			if (temp == '.' && !digitDetected) {
				// error
				return false;
			}
			if ((temp == '+' || temp == '-' || temp == '*' || temp == '/')
					&& !digitDetected) {
				return false;
			}
		}
		return false;
	}

	public boolean nextIsOperation(String string, int index) {
		for (int i = index; i < string.length(); i++) {
			char temp = string.charAt(i);
			if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
				return true;
			}
			if (!Character.isDigit(temp)) {
				return false;
			}
		}
		return false;
	}

	/**
	 * Return true if previous symbol is dot.
	 * 
	 * @return
	 */
	public boolean previousIsDot(String string) {
		if (string.length() > 0) {
			if ((string.charAt(string.length() - 1) == '.')) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Return true if previous symbol is digit.
	 * 
	 * @return
	 */
	public boolean previousIsDigit(String string) {
		if (string.length() > 0) {
			if (Character.isDigit(string.charAt(string.length() - 1))) {
				return true;
			}
			return false;
		}
		return false;
	}
}
