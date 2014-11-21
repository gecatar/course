package com.sirma.itt.evgeni.task7;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.TextUtil;

/**
 * Generate random string.
 * @author Evgeni Stefanov
 *
 */
public class RandomStringRunner {

	/**
	 * User must enter length of the string.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter lenght of string:");
		System.out.println(TextUtil.getRandomString(ConsoleReader.readInt()));
	}

}