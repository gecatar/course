package com.sirma.itt.evgeni.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Contain methods for mathematical calculations.
 * 
 * @author Evgeni Stefanov
 */
public class MathUtil {

	/**
	 * Sum two integer values.
	 * 
	 * @param firstNumber
	 *            first of two values.
	 * @param secondNumber
	 *            second of two values.
	 * @return sum of first and second number
	 */
	public static int sum(int firstNumber, int secondNumber) {

		return firstNumber + secondNumber;
	}

	/**
	 * Sum two float values.
	 * 
	 * @param firstNumber
	 *            first of two values.
	 * @param secondNumber
	 *            second of two values.
	 * @return sum of first and second number
	 */
	public static float sum(float firstNumber, float secondNumber) {

		return firstNumber + secondNumber;
	}

	/**
	 * Sum two BigInteger values.
	 * 
	 * @param firstNumber
	 *            first of two values.
	 * @param secondNumber
	 *            second of two values.
	 * @return sum of first and second number
	 */
	public static BigInteger sum(BigInteger firstNumber, BigInteger secondNumber) {

		firstNumber = firstNumber.add(secondNumber);
		return firstNumber;
	}

	/**
	 * Sum two BigDecimal values.
	 * 
	 * @param firstNumber
	 *            first of two values.
	 * @param secondNumber
	 *            second of two values.
	 * @return sum of first and second number
	 */
	public static BigDecimal sum(BigDecimal firstNumber, BigDecimal secondNumber) {

		firstNumber = firstNumber.add(secondNumber);
		return firstNumber;
	}

	/**
	 * Return Greatest Common Divisor between two numbers.
	 * 
	 * @param firstNumber
	 *            first of two input values.
	 * @param secondNumber
	 *            second of two input values.
	 * @return Greatest Common Multiple of two values.
	 */
	public static int getGreatestCommonDivisor(int firstNumber, int secondNumber) {

		while (firstNumber != secondNumber) {
			if (firstNumber < secondNumber) {
				secondNumber -= firstNumber;
			} else {
				firstNumber -= secondNumber;
			}
		}
		return firstNumber;
	}

	/**
	 * Find Least Common Multiple of two integer values.
	 * 
	 * @param firstNumber
	 *            first of two integer values.
	 * @param secondNumber
	 *            second of two integer values.
	 * @return Least Common Multiple of two values.
	 */
	public static int getLeastCommonMultiple(int firstNumber, int secondNumber) {

		int temp = firstNumber * secondNumber;
		while (firstNumber != secondNumber) {
			if (firstNumber < secondNumber) {
				secondNumber -= firstNumber;
			} else {
				firstNumber -= secondNumber;
			}
		}

		return temp / firstNumber;
	}

	/**
	 * Find sum of two long numbers.
	 * 
	 * @param firstNumber
	 *            Long number represented as string.
	 * @param secondNumber
	 *            Long number represented as string.
	 * @return Sum of two numbers as string.
	 */
	public static String sumString(String firstNumber, String secondNumber)
			throws IllegalArgumentException {

		StringBuilder sumBuilder = new StringBuilder();
		char firstDigit, secondDigit;
		int divisionRest = 0;
		int buff = 0;
		int indexA;
		int indexB;
		if (firstNumber != null) {
			indexA = (firstNumber.length() - 1);
		} else {
			throw new IllegalArgumentException("Invalid User input!!!");
		}
		if (secondNumber != null) {
			indexB = (secondNumber.length() - 1);
		}else{
			throw new IllegalArgumentException("Invalid User input!!!");
		}
		while (indexA >= 0 || indexB >= 0 || divisionRest != 0) {

			if (indexA >= 0) {
				firstDigit = firstNumber.charAt(indexA);
				indexA--;
			} else {
				firstDigit = '0';
			}
			if (indexB >= 0) {
				secondDigit = secondNumber.charAt(indexB);
				indexB--;
			} else {
				secondDigit = '0';
			}
			if (!Character.isDigit(firstDigit)
					|| !Character.isDigit(secondDigit)) {
				throw new IllegalArgumentException("Enter only integers");
			}
			buff = Character.getNumericValue(firstDigit)
					+ Character.getNumericValue(secondDigit) + divisionRest;
			divisionRest = 0;
			if (buff > 9) {
				divisionRest = (buff / 10);
				sumBuilder.append(buff % 10);
			} else {
				sumBuilder.append(buff);
			}
		}

		sumBuilder.reverse();

		return sumBuilder.toString();
	}

}
