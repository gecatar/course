package com.sirma.itt.evgeni.task1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.Calculator;

public class ExtactOperationTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(6, calculator.extractOperations("-5*2-4+4-3*3+9")
				.size());
		// fail("Not yet implemented");
	}
}
