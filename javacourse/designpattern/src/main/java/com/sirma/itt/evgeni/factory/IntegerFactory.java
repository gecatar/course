package com.sirma.itt.evgeni.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sirma.itt.evgeni.commands.Command;
import com.sirma.itt.evgeni.commands.DeductIntegerCommand;
import com.sirma.itt.evgeni.commands.DivisionIntegerCommand;
import com.sirma.itt.evgeni.commands.MultiplyIntegerCommand;
import com.sirma.itt.evgeni.commands.PowIntegerCommand;
import com.sirma.itt.evgeni.commands.SumIntegerCommand;

/**
 * Create arithmetical commands.
 * 
 * @author GecaTM
 *
 */
public class IntegerFactory implements Factory {

	private static final Logger LOGGER = Logger.getLogger(IntegerFactory.class
			.getName());

	/**
	 * Create new instance.
	 */
	public Command createInstance(String type) {
		if (type.equalsIgnoreCase("multiply")) {
			return new MultiplyIntegerCommand();
		}
		if (type.equalsIgnoreCase("deduct")) {
			return new DeductIntegerCommand();
		}
		if (type.equalsIgnoreCase("division")) {
			return new DivisionIntegerCommand();
		}
		if (type.equalsIgnoreCase("sum")) {
			return new SumIntegerCommand();
		}
		if (type.equalsIgnoreCase("pow")) {
			return new PowIntegerCommand();
		}
		return null;
	}

	/**
	 * Create new instance whit reflection.
	 */
	public Command createInstanceReflection(String type) {
		try {
			return (Command) Class.forName(type).newInstance();
		} catch (ReflectiveOperationException e) {
			LOGGER.log(Level.SEVERE, "Error when creating object.", e);
			return null;
		}
	}
}