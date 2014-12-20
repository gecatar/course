package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Control access to mathematical operations.
 * 
 * @author Evgeni Stefanov
 *
 */
public class ProxyRunner {

	/**
	 * Allow user to use mathematical function on class calculator. For some
	 * user some operations are not allowed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CalculatorProxy calculator = new CalculatorProxy("User");
		System.out.println("Enter integer value to decrement:");
		System.out.println(calculator.decrement(ConsoleReader.readInt()));
		System.out.println("Enter two numbers to sum them:");
		System.out.println(calculator.sum(ConsoleReader.readInt(),
				ConsoleReader.readInt()));

	}

}
