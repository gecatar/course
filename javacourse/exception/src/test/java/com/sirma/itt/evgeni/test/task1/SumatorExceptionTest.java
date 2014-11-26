package com.sirma.itt.evgeni.test.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;
/**
 * Check correct exception throwing on MathUtil class.
 * @author Evgeni Stefanov
 *
 */
public class SumatorExceptionTest {
	
	/**
	 * Pass two long numbers and check result.
	 * Numbers are represented as Strings.
	 */
	@Test
	public void sumStringTest() {
		
		String firstNumber = "999999999";
		String secondNumber = "1";
		String expected = "1000000000";
		String actual = MathUtil.sumString(firstNumber, secondNumber);
		
		assertEquals(expected, actual);
		
	}
	
	/**
	 * Pass two long numbers and check result.
	 * Numbers are represented as Strings.
	 */
	@Test
	public void sumStringSecondTest() {
		
		String firstNumber = "223";
		String secondNumber = "323";
		String expected = "546";
		String actual = MathUtil.sumString(firstNumber, secondNumber);
		
		assertEquals(expected, actual);
		
	}
	
	/**
	 * Check behavior when null pointer are passed.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void NullPointerTest(){
		String firstNumber = null;
		String secondNumber = null;
		MathUtil.sumString(firstNumber, secondNumber);
	}

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
