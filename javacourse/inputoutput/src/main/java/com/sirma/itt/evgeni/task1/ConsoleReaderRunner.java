package com.sirma.itt.evgeni.task1;

import com.sirma.itt.evgeni.util.ConsoleReader;


/**
 * Use ConsoleReader class to get only correct user input.
 * Reading from console continue while correct data is entered.
 * @author Evgeni Stefanov
 *
 */
public class ConsoleReaderRunner {

	/**
	 * Read user input while correct data is entered.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("User must enter Integer value. "
				+ "Reading from console continue while correct data is entered.");
		ConsoleReader.readInt();
		System.out.println("User must enter string:");
		ConsoleReader.readString();
		System.out.println("User must enter float value:");
		ConsoleReader.readFloat();
		System.out.println("User must enter char:");
		ConsoleReader.readChar();
	}

}