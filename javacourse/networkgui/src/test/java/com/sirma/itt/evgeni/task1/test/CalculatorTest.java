package com.sirma.itt.evgeni.task1.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.sirma.itt.evgeni.task1.Calculator;
import com.sirma.itt.evgeni.task1.Operation;

/**
 * Check correct execution on operations.
 * 
 * @author GecaTM
 *
 */
public class CalculatorTest {

	Calculator calculator = new Calculator(20);

	/**
	 * Check for expected exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void calculateExceptionTest() {
		calculator.calculate(new Operation(new BigDecimal("12"),
				new BigDecimal("12"), ' '));
	}

	/**
	 * Check for correct execution on operation.
	 */
	public void calculateNumbersTest() {
		Assert.assertTrue(new BigDecimal("3").equals(calculator
				.calculate(new Operation(new BigDecimal("1"), new BigDecimal(
						"2"), '+'))));
		Assert.assertTrue(new BigDecimal("-1").equals(calculator
				.calculate(new Operation(new BigDecimal("1"), new BigDecimal(
						"2"), '-'))));
		Assert.assertTrue(new BigDecimal("2").equals(calculator
				.calculate(new Operation(new BigDecimal("1"), new BigDecimal(
						"2"), '*'))));
		Assert.assertTrue(new BigDecimal("1").equals(calculator
				.calculate(new Operation(new BigDecimal("2"), new BigDecimal(
						"2"), '/'))));
	}

}
