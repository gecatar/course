package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Sumator scan passed strings and throw exception if is passed string contain
 * different values from numbers.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ExceptionRunner {

	/**
	 * Read user input and Sum two Numbers represented as String.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Sum two long numbers.");
		System.out.println("Enter first number:");
		String firstNumber = ConsoleReader.readString();
		System.out.println("Enter second number:");
		String secondNumber = ConsoleReader.readString();
		try {
			System.out.println(MathUtil.sumString(firstNumber, secondNumber));
		} catch (IllegalArgumentException e) {
			System.out
					.println("Invalid user data. You must enter only numbers.");
		}
	}
}