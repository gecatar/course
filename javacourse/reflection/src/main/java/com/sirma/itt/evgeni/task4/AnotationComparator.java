package com.sirma.itt.evgeni.task4;

import java.util.Comparator;

import com.sirma.itt.evgeni.reflection.TestClass;

/**
 * Read annotation values and determine which is bigger.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class AnotationComparator implements Comparator<TestClass> {

	public int compare(TestClass firstClass, TestClass secondClass) {
		return AnnotationReader.getPriority(firstClass)
				- AnnotationReader.getPriority(secondClass);
	}

}
