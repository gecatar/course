package com.sirma.itt.evgeni.test.task2;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.sirma.itt.evgeni.task2.RangeValidator;
import com.sirma.itt.evgeni.util.ValueNotInRangeException;

/**
 * Check for expected exception when passed values are not in selected range.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ReadIntervalExceptionTest {

	/**
	 * Pass incorect data and wait for exception.
	 * 
	 * @throws ValueNotInRangeException
	 */
	@Test(expected = ValueNotInRangeException.class)
	public void rangeValidatorTest() throws ValueNotInRangeException {
		RangeValidator.chekIsInRange(0, 1, 2);
	}

	/**
	 * Check behavior when correct data is passed.
	 */
	@Test
	public void readIntervalSecondTest() {
		try {
			RangeValidator.chekIsInRange(0, 2, 1);

		} catch (ValueNotInRangeException e) {
			fail("Un expected: ValueNotInRangeException!!!!");
		}
	}
}