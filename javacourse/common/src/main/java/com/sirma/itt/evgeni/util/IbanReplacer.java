package com.sirma.itt.evgeni.util;

import java.util.regex.Pattern;

/**
 * Replace symbols in valid iban numbers.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class IbanReplacer {

	private static final Pattern pattern = Pattern
			.compile("(?!:<iban>)[A-Z]{2}[0-9]{2}\\s[A-Z]{4}\\s[1-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s(?=[0-9]{4}[</iban>])");

	/**
	 * Replace characters on ibans.
	 * 
	 * @param iban
	 * @return
	 */
	public static String replaceFirstCharacter(String iban) {
		return pattern.matcher(iban).replaceAll("*****");
	}
}
