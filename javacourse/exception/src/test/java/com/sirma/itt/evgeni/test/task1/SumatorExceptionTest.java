package com.sirma.itt.evgeni.test.task1;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;
/**
 * Check correct exception throwing on MathUtil class.
 * @author Evgeni Stefanov
 *
 */
public class SumatorExceptionTest {

	/**
	 * Check for exception event.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void test() {
		String firstNumber = "71287812738127498172481249";
		String secondNumber = "928398329482349o099";
		MathUtil.sumString(firstNumber, secondNumber);
	}

}
