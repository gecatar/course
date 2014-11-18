package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ConsoleReader;

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

		try {
			System.out
					.println("Verify user input. Must be in range (min - max).");
			System.out.println("Enter minimum value");
			int min = ConsoleReader.readInt();
			System.out.println("Enter maximum value");
			int max = ConsoleReader.readInt();
			ConsoleReader.readIntInterval(min, max);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}