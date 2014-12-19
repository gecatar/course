package com.sirma.itt.evgeni.factory;

public class FactoryProducer {

	public static Factory getFactory(String type) {

		if (type.equalsIgnoreCase("double")) {
			return new DoubleFactory();
		}
		if (type.equalsIgnoreCase("integer")) {
			return new IntegerFactory();
		}
		return null;

	}
}
