package com.sirma.itt.evgeni.factory;

/**
 * Create Factory for computation commands.
 * 
 * @author GecaTM
 *
 */
public class FactoryProducer {

	/**
	 * Create factory's.
	 */
	public static Factory getFactory(String type) {

		if (type.equalsIgnoreCase("integer")) {
			return new IntegerFactory();
		}
		return null;

	}
}
