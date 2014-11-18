package com.sirma.itt.evgeni.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class ReflectionUtil {

	/**
	 * @param obj
	 *            class that will be manipulated.
	 * @throws IllegalArgumentException
	 *             while setting up class.
	 * @throws IllegalAccessException
	 *             while setting up class .
	 */
	public static void setClass(Object object) {
		Class<?> cl = object.getClass();
		System.out.println("----------------------------");
		System.out.println("Class name:" + cl.getName());
		System.out.println("Class type:" + cl.getName());
		System.out.println("Super class" + cl.getSuperclass().getName());
		System.out.println("----------------------------");
		for (Field field : cl.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				System.out.println(field.getType().toString() + " "
						+ field.getName() + " = " + field.get(object));
				System.out.println("Type 1 to set this value.");
				if (ConsoleReader.readInt() == 1) {
					setValue(field, object);
				}
			} catch (IllegalAccessException e) {
				System.out.println("Error durring setup!!!");
				e.printStackTrace();
			}

		}
	}

	/**
	 * Set primitive values.
	 * 
	 * @param field
	 *            that will be setup
	 * @param obj
	 *            instance of class
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	static void setValue(Field field, Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		Type type = field.getType();
		if (type == Boolean.TYPE) {
			field.setBoolean(obj, new Boolean(ConsoleReader.readString()));
		}
		if (type == Byte.TYPE) {
			field.setByte(obj, new Byte(ConsoleReader.readString()));
		}
		if (type == Character.TYPE) {
			field.setChar(obj, ConsoleReader.readString().charAt(0));
		}
		if (type == Double.TYPE) {
			field.setDouble(obj, Double.parseDouble(ConsoleReader.readString()));
		}
		if (type == Integer.TYPE) {
			field.setInt(obj, new Integer(ConsoleReader.readInt()));
		}
		if (type == Float.TYPE) {
			field.setFloat(obj, new Float(ConsoleReader.readString()));
		}
		if (type == Long.TYPE) {
			field.setLong(obj, Long.parseLong(ConsoleReader.readString()));
		}
		if (type == Short.TYPE) {
			field.setShort(obj, Short.parseShort(ConsoleReader.readString()));
		}
	}

	/**
	 * List fields on the class.
	 * 
	 * @param obj
	 *            object that will be accessed whit annotation. Display
	 *            information about:name, type, methods.
	 */
	public static void analyse(Object obj) {
		Class<?> cl = obj.getClass();
		System.out.println("----------------------------");
		System.out.println("Class name:" + cl.getName());
		System.out.println("Class type:" + cl.getName());
		System.out.println("Super class" + cl.getSuperclass().getName());
		System.out.println("----------------------------");
		Method[] methods = cl.getDeclaredMethods();
		System.out.println("Class contain " + methods.length + " methods.");
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
		}
		System.out.println("----------------------------");
		Field[] fields = cl.getDeclaredFields();
		System.out.println("Class contain " + fields.length + " fields.");
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			try {
				System.out.println(fields[i].getType().toString() + " "
						+ fields[i].getName() + " = " + fields[i].get(obj));
			} catch (IllegalAccessException e) {
				System.out.println("Error while reading data!!!");
				e.printStackTrace();
			}
		}

	}

	/**
	 * Create new instance of class by passed name as string. List interfaces
	 * and annotations. List class annotations, super class and interfaces.
	 * 
	 * @param name
	 */
	public static Object CreateFromName(String name) {
		Class<?> cl = null;
		Object object = null;
		try {
			cl = Class.forName(name);
			Constructor<?> constr = cl.getConstructor();
			object = constr.newInstance();
			System.out.println("----------------------------------");
			System.out.println("Super class:" + cl.getSuperclass().toString());
			System.out.println("----------------------------------");
			System.out.println("Interfaces:");
			for (Class<?> inf : cl.getInterfaces()) {
				System.out.println("Interface:" + inf.getName().toString());
			}
			System.out.println("----------------------------------");
			System.out.println("Anotations:");
			for (Annotation anotation : cl.getAnnotations()) {
				System.out.println("Anotation:" + anotation.toString());
			}
			for (Method method : cl.getDeclaredMethods()) {
				for (Annotation anotation : method.getAnnotations()) {
					System.out.println(anotation.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("Error while creating!!!");
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * Read private fields and execute private methods.
	 * 
	 * @param obj
	 *            instance of object that will be read from.
	 */
	public static void readPrivate(Object object) {

		Class<?> cl = object.getClass();
		System.out.println("-----------------------------");
		for (Method method : cl.getDeclaredMethods()) {
			if (Modifier.isPrivate(method.getModifiers())) {
				method.setAccessible(true);
				System.out.println(method.getName());
				try {
					method.invoke(object);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println("----------------------------");
		for (Field field : cl.getDeclaredFields()) {
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
				try {
					System.out.println(field.getType().toString() + " "
							+ field.getName() + " = " + field.get(object));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}