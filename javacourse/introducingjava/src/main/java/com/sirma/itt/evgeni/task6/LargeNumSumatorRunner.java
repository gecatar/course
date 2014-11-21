package com.sirma.itt.evgeni.task6;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Sum large numbers. Represented as Strings.
 * @author Evgeni Stefanov
 *
 */
public class LargeNumSumatorRunner {

	/**
	 * Call MathUtil whit user values.
	 * User must enter two numbers.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Summing large number:");
		System.out.println("Enter first number:");
		String firstNumber = ConsoleReader.readString();
		System.out.println("Enter second number:");
		String secondNumber = ConsoleReader.readString();
		System.out.println("Sum is:"+MathUtil.sumString(firstNumber, secondNumber));
	}

}
