package com.sirma.itt.evgeni.task4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.sirma.itt.evgeni.reflection.Priority;

/**
 * Read annotations value from declared methods. Find maximal priority index of
 * class.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class AnnotationReader {

	/**
	 * Method whit highest priority determine mutual priority value.
	 * 
	 * @param obj
	 *            class which priority values will be extracted.
	 * @return value of anotation whit bigest priority.
	 */
	public static int getPriority(Object obj) {

		int priority = 0;
		Class<?> cl = obj.getClass();
		for (Method method : cl.getDeclaredMethods()) {
			Annotation[] annotations = method.getDeclaredAnnotations();
			for (int j = 0; j < annotations.length; j++) {
				if (annotations[j].annotationType() == Priority.class) {
					Priority anotation = (Priority) annotations[j];
					if (priority < anotation.priorityIndesx()) {
						priority = anotation.priorityIndesx();

					}
				}
			}
		}
		return priority;
	}
}