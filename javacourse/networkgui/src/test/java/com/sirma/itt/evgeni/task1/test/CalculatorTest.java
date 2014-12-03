package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.Calculator;

public class CalculatorTest {

	Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	/**
	 * Check correct calculating on operations.
	 */
	@Test
	public void calculateOperationsTest() {
		assertEquals(new BigDecimal("10"),
				calculator.calculateOperations(calculator
						.extractOperations("5*2-4+4-3*3+9")));
		assertEquals(new BigDecimal("8"),
				calculator.calculateOperations(calculator
						.extractOperations("3*3-2*2/4")));
	}

	/**
	 * Check correct extracting of Decimal numbers.
	 */
	@Test
	public void getNumberTest() {
		assertEquals("588884", calculator.getNumber("1234567.876-588884", 12));
		assertEquals("1234567.876",
				calculator.getNumber("1234567.876-588884", 0));
	}

	/**
	 * Check number of extracted operations.
	 */
	@Test
	public void extractOperationTest() {
		assertEquals(6, calculator.extractOperations("1+2+3*2+4/2*2").size());

	}

}
