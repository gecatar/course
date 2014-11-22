package com.sirma.itt.evgeni.task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Create classes via reflection, list information about them.
 * 
 * @author GecaTM
 *
 */
public class ClassCreator {

	/**
	 * List interfaces.
	 * 
	 * @param object
	 *            the object that interfaces will be listed.
	 * @return interfaces.
	 */
	public String listInterfaces(Object object) {
		if (object != null) {
			Class<?> cl = object.getClass();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Intefaces:\n");
			for (Class<?> interfc : cl.getInterfaces()) {
				stringBuilder.append(interfc.getName()).append("\n");
			}
			return stringBuilder.toString();
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
			Class<?> cl = object.getClass();
			stringBuilder.append("Super class:").append(cl.getSuperclass());
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
		Class<?> cl = null;
		Object object;
		Constructor<?> constructor = null;
		try {
			cl = Class.forName(name);
			constructor = cl.getConstructor();
			object = constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}

		return object;
	}

}
