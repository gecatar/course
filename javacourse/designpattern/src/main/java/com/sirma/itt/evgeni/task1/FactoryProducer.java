package com.sirma.itt.evgeni.task1;

public class FactoryProducer {

	public static Factory getFactory(String type) {

		if (type.equalsIgnoreCase("decimal")) {
			return new DecimalFactory();
		}
		if (type.equalsIgnoreCase("integer")) {
			return new IntegerFactory();
		}
		return null;

	}
}
