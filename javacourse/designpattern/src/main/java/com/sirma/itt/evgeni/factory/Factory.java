package com.sirma.itt.evgeni.factory;

import com.sirma.itt.evgeni.commands.Command;

/**
 * Abstract factory interface.
 * 
 * @author root
 *
 */
public interface Factory {

	/**
	 * Create instance.
	 */
	public Command createInstance(String type);

	/**
	 * Create instance whit reflection.
	 */
	public Command createInstanceReflection(String type);
}
