package com.sirma.itt.evgeni.task4.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.sirma.itt.evgeni.reflection.PriorityFirst;
import com.sirma.itt.evgeni.reflection.PrioritySecond;
import com.sirma.itt.evgeni.reflection.PriorityThird;
import com.sirma.itt.evgeni.reflection.TestClass;
import com.sirma.itt.evgeni.task4.AnotationComparator;

/**
 * Check correct extracting on annotation values.
 * 
 * @author GecaTM
 * 
 */
public class AnnotationReaderComparatorTest {

	@Test
	public void annotationTest() {
		TestClass[] list = new TestClass[3];
		list[0] = new PriorityThird();
		list[1] = new PrioritySecond();
		list[2] = new PriorityFirst();
		Arrays.sort(list, new AnotationComparator());
		assertTrue(list[0].getClass() == PriorityFirst.class);
		assertTrue(list[1].getClass() == PrioritySecond.class);
		assertTrue(list[2].getClass() == PriorityThird.class);
	}

}
