package com.sirma.itt.evgeni.task7;

import com.sirma.itt.evgeni.task1.AbstractFactory;
import com.sirma.itt.evgeni.task1.Calculator;
import com.sirma.itt.evgeni.task1.FactoryProducer;
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

		Calculator calculator = new Calculator();
		CommandInvoker invoker = new CommandInvoker();

		AbstractFactory factory = FactoryProducer.getFactory("command");

		invoker.addOperation('-', factory.getCommand("deduct", calculator));
		invoker.addOperation('*', factory.getCommand("multiply", calculator));
		invoker.addOperation('/', factory.getCommand("division", calculator));
		invoker.addOperation('^', factory.getCommand("pow", calculator));

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