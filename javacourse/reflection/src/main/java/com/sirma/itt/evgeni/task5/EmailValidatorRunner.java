package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.ConsoleReader;
import com.sirma.itt.evgeni.util.TextUtil;

/**
 * Validate e mail addresses;
 * 
 * @author Evgeni Stefanov
 * 
 */
public class EmailValidatorRunner {

	/**
	 * Read addresses and check their syntax.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Validate e mail adresses:");
		System.out.println("Enter e mail adress:");
		if (TextUtil.isValidMail(ConsoleReader.readString())) {
			System.out.println("Adress is valid.");
		} else {
			System.out.println("Adress is not valid!!!!");
		}
	}

}
