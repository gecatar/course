package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Find greatest common divisor.
 * @author Evgeni Stefanov
 *
 */
public class GreatestCommonDivisorRunner {

	/**
	 * Prompt user to enter two numbers and find greatest common divisor.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Find Greatest Common Disor.");
		System.out.println("Enter first number:");
		int firstNumber = ConsoleReader.readInt();
		System.out.println("Enter second number:");
		int secondNumber = ConsoleReader.readInt();

		System.out.println("Gratest Common Divisor of numbers:"
				+ MathUtil.getGreatestCommonDivisor(firstNumber, secondNumber));

	}

}