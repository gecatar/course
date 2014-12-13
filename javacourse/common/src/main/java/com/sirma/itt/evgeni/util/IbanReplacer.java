package com.sirma.itt.evgeni.util;

import java.util.regex.Pattern;

public class IbanReplacer {

	private static final Pattern pattern = Pattern
			.compile("(?!:<iban>)[A-Z]{2}[0-9]{2}\\s[A-Z]{4}\\s[1-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s(?=[0-9]{4}[</iban>])");

	public static String replaceFirstCharacter(String iban) {
		return pattern.matcher(iban).replaceAll("*****");
	}
}
