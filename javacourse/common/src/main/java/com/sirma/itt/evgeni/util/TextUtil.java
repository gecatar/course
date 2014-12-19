package com.sirma.itt.evgeni.util;

import java.util.Random;

/**
 * Contain text processing utility.
 * 
 * @author Evgeni Stefanov
 */
public class TextUtil {

	/**
	 * Generate random string that contain only numbers and letters.
	 * 
	 * @param count
	 *            is length on string.
	 * @return generated string.
	 */
	public static String getRandomString(int count) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			int group = (int) (Math.random() * 3);
			switch (group) {
			case 0:
				stringBuilder.append((char) (48 + (int) (Math.random() * 10)));
				break;
			case 1:
				stringBuilder.append((char) (65 + (int) (Math.random() * 26)));
				break;
			case 2:
				stringBuilder.append((char) (97 + (int) (Math.random() * 26)));
				break;
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Generate random string whit given length.
	 * 
	 * @param count
	 *            length of string.
	 * @return string generated string.
	 */
	public static String getRandomStringV2(int count) {

		StringBuilder stringBuilder = new StringBuilder();
		Random rand = new Random();
		char ch;

		for (int i = 0; i < count; i++) {

			do {
				ch = (char) Math.abs(rand.nextInt());
			} while ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')
					&& (ch < '0' || ch > '9'));

			stringBuilder.append(ch);
		}

		return stringBuilder.toString();
	}

}
