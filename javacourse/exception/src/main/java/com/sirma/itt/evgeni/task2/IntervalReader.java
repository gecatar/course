package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.interfaces.UserInputReader;
import com.sirma.itt.evgeni.util.ValueNotInRangeException;

/**
 * Check user input values. If values are not in range an exception is thrown.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class IntervalReader {

	UserInputReader reader;

	public IntervalReader(UserInputReader reader) {
		this.reader = reader;
	}

	/**
	 * Return values only if there are in range min max.
	 * @param min the minimum value - included.
	 * @param max the maximum value - excluded.
	 * @throws ValueNotInRangeException
	 */
	public void readInterval(int min, int max) throws ValueNotInRangeException {
		int value = reader.readInt();
		if (value < min || value >= max) {
			throw new ValueNotInRangeException("Value is not in range!!!");
		}
	}
}
