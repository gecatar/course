package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;

public class GreatestCommonDivisorTest {

	/**
	 * Pass two number and check correct finding on greatest common divisor.
	 */
	@Test
	public void firstTest() {

		int expectedGCD, actualGCD;
		int firstNumber = 30;
		int secondNumber = 6;
		expectedGCD = 6;
		actualGCD = MathUtil
				.getGreatestCommonDivisor(firstNumber, secondNumber);
		assertEquals(expectedGCD, actualGCD);
	}
	
	/**
	 * Pass two number and check correct finding on greatest common divisor.
	 */
	@Test
	public void secondTest() {

		int expectedGCD, actualGCD;
		int firstNumber = 3;
		int secondNumber = 9;
		expectedGCD = 3;
		actualGCD = MathUtil
				.getGreatestCommonDivisor(firstNumber, secondNumber);
		assertEquals(expectedGCD, actualGCD);
	}

}
