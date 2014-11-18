package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.util.TextUtil;

public class TextutilTest {

	/**
	 * Check length of generated string.
	 */
	@Test
	public void test() {
		String str = TextUtil.getRandomString(10);
		int expectedResult = 10;
		assertEquals(expectedResult, str.length());
	}

}
