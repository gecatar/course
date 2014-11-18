package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;

public class MathUtilTest {

	/**
	 * Pass two long numbers and check result.
	 * Numbers are represented as Strings.
	 */
	@Test
	public void mathUtilFirstTest() {
		
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
	public void mathUtilSecondTest() {
		
		String firstNumber = "223";
		String secondNumber = "323";
		String expected = "546";
		String actual = MathUtil.sumString(firstNumber, secondNumber);
		
		assertEquals(expected, actual);
		
	}

}
