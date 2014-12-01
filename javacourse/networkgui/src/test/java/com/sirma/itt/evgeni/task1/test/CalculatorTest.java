package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.Calculator;
import com.sirma.itt.evgeni.task1.Operation;

public class CalculatorTest {

	Calculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@Test
	public void extractOperationsTest() {

		ArrayList<Operation> operations = new ArrayList<Operation>();
		operations.add(new Operation(new BigDecimal("1"), new BigDecimal("2"),
				'-'));
		operations.add(new Operation(new BigDecimal("2"), new BigDecimal("3"),
				'-'));
		operations.add(new Operation(new BigDecimal("3"), new BigDecimal("4"),
				'-'));
		operations.add(new Operation(new BigDecimal("4"), new BigDecimal("5"),
				'-'));
		operations.add(new Operation(new BigDecimal("5"), new BigDecimal("6"),
				'-'));

		calculator.calculateOperations(operations);
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
