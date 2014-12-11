package com.sirma.itt.evgeni.task2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create classes via reflection, list information about them.
 * 
 * @author GecaTM
 * 
 */
public class ClassCreator {

	private static final Logger LOGGER = Logger.getLogger(ClassCreator.class
			.getName());

	/**
	 * List interfaces.
	 * 
	 * @param object
	 *            the object that interfaces will be listed.
	 * @return interfaces.
	 */
	public String listInterfaces(Object object) {
		if (object != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Intefaces:\n");
			for (Class<?> interfc : object.getClass().getInterfaces()) {
				stringBuilder.append(interfc.getName()).append("\n");
			}
			return stringBuilder.toString().trim();
		}
		return "";
	}

	/**
	 * extract parent class name.
	 * 
	 * @param object
	 *            the object which will be read from.
	 * @return parent class name as text.
	 */
	public String getParrent(Object object) {
		if (object != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Super class:").append(
					object.getClass().getSuperclass());
			return stringBuilder.toString();
		}
		return "";
	}

	/**
	 * Create class whit reflection from name.
	 * 
	 * @param name
	 *            the name of class that will be created.
	 * @return created object. Or null if operation is not successful.
	 */
	public Object createFromName(String name) {
		try {
			return Class.forName(name).newInstance();
		} catch (ReflectiveOperationException e) {
			LOGGER.log(Level.SEVERE,
					"Un able to create object whit reflection", e);
			return null;
		}
	}

}
