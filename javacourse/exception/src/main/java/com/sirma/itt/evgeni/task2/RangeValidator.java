package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ValueNotInRangeException;

/**
 * Check user input values. If values are not in range an exception is thrown.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class RangeValidator {

	/**
	 * Return values only if there are in range min max.
	 * @param min the minimum value - included.
	 * @param max the maximum value - excluded.
	 * @throws ValueNotInRangeException
	 */
	public static void chekIsInRange(int min, int max, int value) throws ValueNotInRangeException {
		if (value < min || value >= max) {
			throw new ValueNotInRangeException("Value is not in range!!!");
		}
	}
}
