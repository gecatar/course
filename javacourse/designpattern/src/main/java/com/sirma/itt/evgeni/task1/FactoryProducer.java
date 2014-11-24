package com.sirma.itt.evgeni.task1;

public class FactoryProducer {

	public static AbstractFactory getFactory(String type) {
		
		if (type.equalsIgnoreCase("error")) {
			return null;
		}
		if (type.equalsIgnoreCase("command")) {
			return new CommandFactory();
		}
		
		return null;

	}
}
