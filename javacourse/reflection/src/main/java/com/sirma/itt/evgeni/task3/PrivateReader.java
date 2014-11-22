package com.sirma.itt.evgeni.task3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Read private content from classes via reflection.
 * @author GecaTM
 *
 */
public class PrivateReader {

	/**
	 * Invoke private methods.
	 * @param object
	 * @return list of invoked methods and result status.
	 */
	public String invokePrivateMethods(Object object) {
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		for (Method method : cl.getDeclaredMethods()) {
			if(Modifier.isPrivate(method.getModifiers())){
				stringBuilder.append("invoke:").append(method.getName());
				method.setAccessible(true);
				try {
					method.invoke(object);
					stringBuilder.append(" - OK\n");
				} catch (IllegalAccessException e) {
					stringBuilder.append(" - IllegalAccessException\n");
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					stringBuilder.append(" - IllegalArgumentException\n");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					stringBuilder.append(" - InvocationTargetException\n");
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Read private fields names and values and save it as string.
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
				} catch (IllegalArgumentException e) {
					stringBuilder.append("IllegalArgumentException").append(
							"\n");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					stringBuilder.append("IllegalAccessException").append(
							"\n");
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}
}
