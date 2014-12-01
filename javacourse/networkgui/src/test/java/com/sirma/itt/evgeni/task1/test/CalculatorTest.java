package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.Calculator;

public class CalculatorTest {

	Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@Test
	public void extractOperationsTest() {
		calculator.calculateOperations(calculator
				.extractOperations("1+2+3+4+5"));
	}

	// @Test
	public void getNumberSecondTest() {
		assertEquals("123.456", calculator.getNumber("123.456-789", 0));
	}

	// @Test(expected = IllegalArgumentException.class)
	public void getNumberExceptionTest() {
		assertEquals("123.456", calculator.getNumber("123.456-789", 10));
	}

	// @Test
	public void getNumberTest() {
		assertEquals("123456", calculator.getNumber("123456-789", 0));
	}

}
