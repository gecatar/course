package com.sirma.itt.evgeni.util;

import java.util.Random;

/**
 * Contain text processing utility.
 * @author Evgeni Stefanov
 */
public class TextUtil {
	
	/**
	 * Validate e mail.
	 * @param mail string which will be checked for invalid character.
	 * @return true if e mail is valid.
	 */
	public static boolean isValidMail(String mail) {
		return mail.matches("\\p{Lower}(\\w|-|\\.)*@\\p{Lower}(\\w|-|\\.)*\\.\\p{Lower}*");
	}
	
	/**
	 * Hide character from valid ibans.
	 * @param ibans string whit ibans.
	 * @return
	 */
	public static String replaceIban(String ibans){
		return ibans.replaceAll("(?!:<iban>)[A-Z]{2}[0-9]{2}\\s[A-Z]{4}\\s[1-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s(?=[1-9]{4}[</iban>])","*****");
	}

	/**
	 * Generate random string that contain only numbers and letters.
	 * @param count is length on string.
	 * @return generated string.
	 */
	public static String getRandomString(int count) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			int group = (int) (Math.random() * 3);
			switch (group) {
				case 0:
					stringBuilder.append((char)(48 + (int) (Math.random() * 10)));
					break;
				case 1:
					stringBuilder.append((char)(65 + (int) (Math.random() * 26)));
					break;
				case 2:
					stringBuilder.append((char)(97 + (int) (Math.random() * 26)));
					break;
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Generate random string whit given length.
	 * 
	 * @param count length of string.
	 * @return string generated string.
	 */
	public static String getRandomStringV2(int count) {

		StringBuilder stringBuilder = new StringBuilder();
		Random rand = new Random();
		char ch;

		for (int i = 0; i < count; i++) {

			do {
				ch = (char) Math.abs(rand.nextInt());
			} while ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9'));

			stringBuilder.append(ch);
		}

		return stringBuilder.toString();
	}

}

