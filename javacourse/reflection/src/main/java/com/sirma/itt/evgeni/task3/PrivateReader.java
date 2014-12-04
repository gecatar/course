package com.sirma.itt.evgeni.task3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Read private content from classes via reflection.
 * 
 * @author GecaTM
 * 
 */
public class PrivateReader {

	private static final Logger LOGGER = Logger.getLogger(PrivateReader.class
			.getName());

	/**
	 * Invoke private methods.
	 * 
	 * @param object
	 * @return list of invoked methods and result status.
	 */
	public String invokePrivateMethods(Object object) {
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		for (Method method : cl.getDeclaredMethods()) {
			if (Modifier.isPrivate(method.getModifiers())) {
				stringBuilder.append("invoke:").append(method.getName());
				method.setAccessible(true);
				try {
					method.invoke(object);
					stringBuilder.append(" - OK\n");
				} catch (ReflectiveOperationException e) {
					stringBuilder.append(" - Reflective Exception\n");
					LOGGER.log(Level.SEVERE,
							"Unable to invoke method whit reflection", e);
				}
			}
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Read private fields names and values and save it as string.
	 * 
	 * @param object
	 * @return
	 */
	public String getPrivateFileds(Object object) {
		Class<?> cl = object.getClass();
		cl.getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Private fields:\n");
		for (Field field : cl.getDeclaredFields()) {
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
				stringBuilder.append(field.getName()).append(":");
				try {
					stringBuilder.append(field.get(object)).append("\n");
				} catch (ReflectiveOperationException e) {
					stringBuilder.append("Reflective Exception").append("\n");
					LOGGER.log(Level.SEVERE, "Unable to read private field.", e);
				}
			}
		}
		return stringBuilder.toString().trim();
	}
}
