package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Find least common multiple of two numbers.
 * @author Evgeni Stefanov
 *
 */
public class LeastCommonMultipleRunner {

	/**
	 * Prompt user to enter two numbers.
	 * Call Math.Util.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Find Least Common Multiple.");
		System.out.println("Enter first number:");
		int firstNumber = ConsoleReader.readInt();
		System.out.println("Enter second number:");
		int secondNumber = ConsoleReader.readInt();
		System.out.println("Least Common Multiple of numbers:"
				+ MathUtil.getLeastCommonMultiple(firstNumber, secondNumber));

	}

}