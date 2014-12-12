package com.sirma.itt.evgeni.util;

import java.util.regex.Pattern;

/**
 * Validate e mails.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class EmailValidator {

	private static final Pattern pattern = Pattern
			.compile("\\p{Lower}(\\w|-|\\.)*@\\p{Lower}(\\w|-|\\.)*\\.\\p{Lower}*");

	/**
	 * Return true if email is valid.
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validate(String email) {
		return pattern.matcher(email).matches();
	}
}
