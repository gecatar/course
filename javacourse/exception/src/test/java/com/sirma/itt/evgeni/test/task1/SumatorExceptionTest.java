package com.sirma.itt.evgeni.test.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.evgeni.util.MathUtil;

/**
 * Check correct exception throwing on MathUtil class.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class SumatorExceptionTest {

	/**
	 * Pass two long numbers and check result. Numbers are represented as
	 * Strings.
	 */
	@Test
	public void sumStringTest() {
		assertEquals("1000000000", MathUtil.sumString("1", "999999999"));
	}
	
	/**
	 * Test when String whit zero length is passed.
	 */
	@Test
	public void sumStringEmptySting(){
		assertEquals("999999999", MathUtil.sumString("", "999999999"));
	}

	/**
	 * Pass two long numbers and check result. Numbers are represented as
	 * Strings.
	 */
	@Test
	public void sumStringSecondTest() {
		assertEquals("546", MathUtil.sumString("223", "323"));

	}

	/**
	 * Check behavior when null pointer are passed.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void NullPointerTest() {
		MathUtil.sumString(null, null);
	}

	/**
	 * Check for exception event.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test() {
		MathUtil.sumString("71287812738127498172481249", "928398329482349o099");
	}

}
