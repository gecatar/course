package com.sirma.itt.evgeni.task7;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Use abstract factory to produce commands. Store them in map for later use.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class CalculatorRunner {

	/**
	 * Call calculator and make calculation.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CommandInvoker invoker = new CommandInvoker();
		Calculator calculator = new Calculator();

		invoker.addOperation('-', new DeductCommand(calculator));
		invoker.addOperation('+', new SumCommand(calculator));
		invoker.addOperation('*', new MultiplyCommand(calculator));
		invoker.addOperation('/', new DivisionCommand(calculator));
		invoker.addOperation('^', new PowCommand(calculator));

		while (true) {
			System.out.println("Enter first number:");
			int firstNumber = ConsoleReader.readInt();
			System.out.println("Enter operation:");
			Character operation = ConsoleReader.readChar();
			System.out.println("Enter second number:");
			int secondNumber = ConsoleReader.readInt();
			System.out.println(invoker.invoke(firstNumber, secondNumber,
					operation));
		}
	}
}