package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.commands.Command;
import com.sirma.itt.evgeni.factory.Factory;
import com.sirma.itt.evgeni.factory.FactoryProducer;
import com.sirma.itt.evgeni.util.ConsoleReader;

public class AbstractfactoryRunner {

	public static void main(String[] args) {
		System.out.println("Create multiply command and make calculation.");
		System.out.println("Enter first number:");
		int firstNumber = ConsoleReader.readInt();
		System.out.println("Enter second number:");
		int secondNumber = ConsoleReader.readInt();
		Factory factory = FactoryProducer.getFactory("integer");
		Command command = factory.createInstance("multiply");
		System.out.println("Result is:"
				+ command.calculate(firstNumber, secondNumber));
	}

}
