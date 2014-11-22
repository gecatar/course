package com.sirma.itt.evgeni.task4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.reflection.PrioritySecond;
import com.sirma.itt.evgeni.reflection.PtiorityFirst;
import com.sirma.itt.evgeni.task4.AnnotationReader;
import com.sirma.itt.evgeni.task4.AnotationComparator;

/**
 * Check correct extracting on annotation values.
 * 
 * @author GecaTM
 *
 */
public class AnnotationReaderComparatorTest {

	AnnotationReader anotationReader;
	AnotationComparator annotationComparator;
	PtiorityFirst priorityFirst;
	PrioritySecond prioritySecond;

	@Before
	public void setUp() throws Exception {
		anotationReader = new AnnotationReader();
		annotationComparator = new AnotationComparator();
		priorityFirst = new PtiorityFirst();
		prioritySecond = new PrioritySecond();
	}

	/*
	 * Read annotation values and compare result.
	 */
	@Test
	public void getPriorityTest() {
		int expectedPriority = 99;
		int actualPriority = anotationReader.getPriority(priorityFirst);
		assertEquals(expectedPriority, actualPriority);
		expectedPriority = 84;
		actualPriority = anotationReader.getPriority(prioritySecond);
		assertEquals(expectedPriority, actualPriority);
	}

	/**
	 * Check correct work on compare function.
	 */
	@Test
	public void AnnotationComparatorTest() {
		int expectedCompValue = 15;
		int actualCompValue = annotationComparator.compare(priorityFirst,
				prioritySecond);
		assertEquals(expectedCompValue, actualCompValue);
	}

}
