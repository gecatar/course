package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.interfaces.UserInputReader;
import com.sirma.itt.evgeni.util.InputReader;
import com.sirma.itt.evgeni.util.ValueNotInRangeException;

/**
 * Call ConsoleReader class and pass minimum and maximum expected value. If
 * value is not in range throw IlliegalArgumentException.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ReadIntervalRunner {
	/**
	 * Catch IlleagerArgumenException returned from ConsoleReader class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		UserInputReader reader = new InputReader();
		IntervalReader intervalReader = new IntervalReader(reader);
		try {
			System.out
					.println("Verify user input. Must be in range (min - max).");
			System.out.println("Enter minimum value");
			int min = reader.readInt();
			System.out.println("Enter maximum value");
			int max = reader.readInt();
			intervalReader.readInterval(min, max);
		} catch (ValueNotInRangeException e) {
			System.out.println(e.getMessage());
		}
	}
}