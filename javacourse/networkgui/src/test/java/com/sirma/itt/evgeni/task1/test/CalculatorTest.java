package com.sirma.itt.evgeni.task1.test;

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

	// @Test
	public void calculateOperationSecondTest() {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		operations.add(new Operation(new BigDecimal("1"), new BigDecimal("2"),
				'+'));
		operations.add(new Operation(new BigDecimal("2"), new BigDecimal("18"),
				'+'));
		operations.add(new Operation(new BigDecimal("18"), new BigDecimal("2"),
				'/'));
		operations.add(new Operation(new BigDecimal("2"), new BigDecimal("3"),
				'*'));
		operations.add(new Operation(new BigDecimal("3"), new BigDecimal("1"),
				'*'));

		System.out.println(calculator.calculateOperations(operations));
	}

	// @Test
	public void calculateOperationsTest() {

		ArrayList<Operation> operations = new ArrayList<Operation>();
		operations.add(new Operation(new BigDecimal("1"), new BigDecimal("2"),
				'*'));
		operations.add(new Operation(new BigDecimal("2"), new BigDecimal("3"),
				'*'));
		operations.add(new Operation(new BigDecimal("3"), new BigDecimal("2"),
				'/'));
		operations.add(new Operation(new BigDecimal("2"), new BigDecimal("3"),
				'*'));
		operations.add(new Operation(new BigDecimal("3"), new BigDecimal("1"),
				'+'));

		System.out.println(calculator.calculateOperations(operations));
	}

	@Test
	public void getNumberTest() {
		// System.out.println(calculator.getNumber("1234567.876-54", 0));
		// System.out.println(calculator.getNumber("1234567.876-54", 10));
		System.out.println(calculator.getNumber("1234567.876-588884", 0));
	}

	// @Test
	public void extractOperationTest() {
		ArrayList<Operation> operations = calculator
				.extractOperations("1-3+4+7*3");

	}

}
