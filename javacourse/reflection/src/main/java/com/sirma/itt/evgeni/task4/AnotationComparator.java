package com.sirma.itt.evgeni.task4;

import java.util.Comparator;

import com.sirma.itt.evgeni.reflection.Priority;
import com.sirma.itt.evgeni.reflection.TestClass;

/**
 * Read annotation values and determine which is bigger.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class AnotationComparator implements Comparator<TestClass> {

	@Override
	public int compare(TestClass firstClass, TestClass secondClass) {

		int firstPriority = firstClass.getClass().getAnnotation(Priority.class)
				.priorityIndex();
		int secondPriority = secondClass.getClass()
				.getAnnotation(Priority.class).priorityIndex();
		return firstPriority - secondPriority;
	}

}
