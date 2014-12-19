package com.sirma.itt.evgeni.task7;

import com.sirma.itt.evgeni.factory.Factory;
import com.sirma.itt.evgeni.factory.FactoryProducer;
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

		Factory factory = FactoryProducer.getFactory("integer");

		invoker.addOperation('-', factory.createInstance("deduct"));
		invoker.addOperation('*', factory.createInstance("multiply"));
		invoker.addOperation('/', factory.createInstance("division"));
		invoker.addOperation('^', factory.createInstance("pow"));

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