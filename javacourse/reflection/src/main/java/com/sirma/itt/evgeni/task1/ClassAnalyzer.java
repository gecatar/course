package com.sirma.itt.evgeni.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Get information for classes via reflection.
 * 
 * @author GecaTM
 * 
 */
public class ClassAnalyzer {

	private static final Logger LOGGER = Logger.getLogger(ClassAnalyzer.class
			.getName());

	/**
	 * Get information about Declared Methods.
	 * 
	 * @param object
	 * @return string whit extracted data.
	 */
	public String listDeclaredMethods(Object object) {
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Declared methods:").append("\n");
		for (Method method : cl.getDeclaredMethods()) {
			if (Modifier.isPrivate(method.getModifiers())) {
				stringBuilder.append("private ");
			}
			if (Modifier.isPublic(method.getModifiers())) {
				stringBuilder.append("public ");
			}
			if (Modifier.isProtected(method.getModifiers())) {
				stringBuilder.append("prptected ");
			}
			stringBuilder.append(method.getName()).append("\n");
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Extract Declared fields whit reflection.
	 * 
	 * @param object
	 * @return
	 */
	public String listDeclaredFields(Object object) {
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Declared fields:").append("\n");
		for (Field field : cl.getDeclaredFields()) {
			field.setAccessible(true);
			stringBuilder.append(field.getName()).append(":");
			try {
				stringBuilder.append(field.get(object)).append("\n");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				stringBuilder.append("Unable to read value.").append("\n");
				LOGGER.log(Level.SEVERE, "Unable to read whit reflection,e");
			}
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Get super class name.
	 * 
	 * @param cl
	 * @return
	 */
	public String getSuperClass(Class<?> cl) {
		return cl.getSuperclass().getName();
	}

	/**
	 * Get name of class.
	 * 
	 * @param cl
	 * @return
	 */
	public String getName(Class<?> cl) {
		return cl.getName();
	}

	/**
	 * Get class.
	 * 
	 * @param object
	 * @return
	 */
	public Class<?> getClass(Object object) {
		return object.getClass();
	}
}
