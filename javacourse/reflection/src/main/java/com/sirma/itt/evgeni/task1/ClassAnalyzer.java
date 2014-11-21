package com.sirma.itt.evgeni.task1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Get information for classes via reflection.
 * 
 * @author GecaTM
 *
 */
public class ClassAnalyzer {

	public String listDeclaredMethods(Object object) {
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Declared methods:").append("\n");
		for (Method method : cl.getDeclaredMethods()) {
			if(Modifier.isPrivate(method.getModifiers())){
				stringBuilder.append("private ");
			}
			if(Modifier.isPublic(method.getModifiers())){
				stringBuilder.append("public ");
			}
			if(Modifier.isProtected(method.getModifiers())){
				stringBuilder.append("prptected ");
			}
			stringBuilder.append(method.getName()).append("\n");
		}
		return stringBuilder.toString();
	}
	
	public String listDeclaredFields(Object object){
		Class<?> cl = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Declared fields:").append("\n");
		for(Field field:cl.getDeclaredFields()){
			field.setAccessible(true);
			stringBuilder.append(field.getName()).append(":");
			try {
				stringBuilder.append(field.get(object)).append("\n");
			} catch (IllegalArgumentException e) {
				stringBuilder.append("Unable to read value.").append("\n");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				stringBuilder.append("Unable to read value.").append("\n");
				e.printStackTrace();
			}
		}
		return stringBuilder.toString();
	}

	public String getSuperClass(Class<?> cl) {
		return cl.getSuperclass().getName();
	}

	public String getName(Class<?> cl) {
		return cl.getName();
	}

	public Class<?> getClass(Object object) {
		return object.getClass();
	}
}
